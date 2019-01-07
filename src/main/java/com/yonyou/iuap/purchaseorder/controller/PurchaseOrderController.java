package com.yonyou.iuap.purchaseorder.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import net.sf.json.JSONObject;
import org.apache.commons.lang.WordUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.collections.MapUtils;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderService;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.mvc.type.JsonResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hutool.core.util.StrUtil;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderAssoService;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import org.springframework.util.StringUtils;
import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.context.InvocationInfoProxy;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 说明：请购单主表PurchaseOrder 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-11-5 14:01:30
 */
@Controller
@RequestMapping(value = "/purchase_order")
public class PurchaseOrderController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

	private PurchaseOrderService purchaseOrderService;

	@Autowired
	public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	private PurchaseOrderAssoService purchaseOrderAssoService;

	@Autowired
	public void setPurchaseOrderAssoService(PurchaseOrderAssoService purchaseOrderAssoService) {
		this.purchaseOrderAssoService = purchaseOrderAssoService;
	}
	/**
	 * 获取列表数据
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		try {
			if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE-1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
			Page<PurchaseOrder> page = this.purchaseOrderService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error update database", RequestStatusEnum.FAIL_FIELD);
		}
		
	}
	/**
	 * 主子表合并处理--主表单条保存
	 * @see com.yonyou.iuap.baseservice.controller.GenericAssoController
	 * @param vo
	 * GenericAssoVo ,
	 * 
	 * @return 主表的业务实体
	 */
	/**
	 * 主子表合并处理--保存和修改
	 * @param vo
	 * GenericAssoVo中entity是单条主表数据,sublist是子表数据
	 * @return 主表的业务实体
	 */
	@RequestMapping(value = "/saveAssoVo", method = RequestMethod.POST)
	@ResponseBody
	public Object saveAssoVo(@RequestBody GenericAssoVo<PurchaseOrder> vo) {
		Associative annotation = vo.getEntity().getClass().getAnnotation(Associative.class);
		if (annotation == null || StringUtils.isEmpty(annotation.fkName())) {
			return buildError("", "Nothing got @Associative or without fkName", RequestStatusEnum.FAIL_FIELD);
		}
		Object result = purchaseOrderAssoService.saveAssoVo(vo, annotation);
		return this.buildSuccess(result);
	}

	/**
	 * 主子表合并处理--删除,默认级联删除子表,
	 * 若取消级联删除请在主实体上注解改为@Associative(fkName = "orderId",deleteCascade = false)
	 * @param entities 待删除业务实体
	 * @return 删除成功的实体
	 */
	@RequestMapping(value = "/deleAssoVo", method = RequestMethod.POST)
	@ResponseBody
	public Object deleAssoVo(@RequestBody PurchaseOrder... entities) {
		if (entities.length == 0) {
			return this.buildGlobalError("requst entity must not be empty");
		}
		Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
		if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
			int result = 0;
			for (PurchaseOrder entity : entities) {
				if (StringUtils.isEmpty(entity.getId())) {
					return this.buildError("ID", "ID field is empty:" + entity.toString(),
							RequestStatusEnum.FAIL_FIELD);
				} else {
					result += this.purchaseOrderAssoService.deleAssoVo(entity, annotation);
				}
			}
			return this.buildSuccess(result + " rows(both entity and its sub-entities) has been deleted!");
		} else {
			return this.buildError("", "Nothing got @Associative or without fkName", RequestStatusEnum.FAIL_FIELD);
		}
	}

}