package com.yonyou.iuap.model.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import net.sf.json.JSONObject;
import org.apache.commons.lang.WordUtils;
import java.io.Serializable;

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
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.model.service.ModelService;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.mvc.type.JsonResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hutool.core.util.StrUtil;

/**
 * 说明：model测试 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-19 16:29:48
 */
@Controller
@RequestMapping(value = "/origin_model")
public class ModelController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(ModelController.class);

	private ModelService modelService;

	@Autowired
	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		if (pageRequest.getPageSize() == 1) {
			Integer allCount = Integer.MAX_VALUE-1;
			pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
		}
		Page<Model> page = this.modelService.selectAllByPage(pageRequest, searchParams);
		return this.buildSuccess(page);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public Object get(PageRequest pageRequest, SearchParams searchParams) {
		String id = MapUtils.getString(searchParams.getSearchMap(), "id");
		if (id == null) {
			return this.buildSuccess();// 前端约定传空id则拿到空对象
		}
		if (StrUtil.isBlank(id)) {
			return this.buildError("msg", "主键id参数为空!", RequestStatusEnum.FAIL_FIELD);
		} else {
			Model entity = this.modelService.findById(id);
			return this.buildSuccess(entity);
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody Model entity) {
		try {
			this.modelService.save(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	@RequestMapping(value = "/saveBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBatch(@RequestBody List<Model> listData) {
		this.modelService.saveBatch(listData);
		return this.buildSuccess();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Model entity) throws Exception {
		this.modelService.delete(entity);
		return super.buildSuccess();
	}

	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<Model> listData) throws Exception {
		this.modelService.deleteBatch(listData);
		return super.buildSuccess();
	}

	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody Model entity) {
		try {
			this.modelService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody Model entity) {
		try {
			this.modelService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

}