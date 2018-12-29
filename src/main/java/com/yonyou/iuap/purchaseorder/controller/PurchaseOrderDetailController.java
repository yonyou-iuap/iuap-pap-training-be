package com.yonyou.iuap.purchaseorder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrderDetail;
import com.yonyou.iuap.purchaseorder.service.PurchaseOrderDetailService;

import cn.hutool.core.util.StrUtil;

/**
 * 说明：请购单详情表_物料表 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-11-5 17:23:26
 */
@Controller
@RequestMapping(value = "/purchase_order_detail")
public class PurchaseOrderDetailController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailController.class);

	private PurchaseOrderDetailService purchaseOrderDetailService;

	@Autowired
	public void setPurchaseOrderDetailService(PurchaseOrderDetailService purchaseOrderDetailService) {
		this.purchaseOrderDetailService = purchaseOrderDetailService;
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
		if (pageRequest.getPageSize() == 1) {
			Integer allCount = Integer.MAX_VALUE-1;
			pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
		}
		Page<PurchaseOrderDetail> page = this.purchaseOrderDetailService.selectAllByPage(pageRequest, searchParams);
		return this.buildSuccess(page);
	}
	/**
	 * 删除数据
	 * @param listData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<PurchaseOrderDetail> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.purchaseOrderDetailService.deleteBatch(listData);
		return super.buildSuccess();
	}
}