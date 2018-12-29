package com.yonyou.iuap.tree.controller;

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
import com.yonyou.iuap.tree.entity.TableDemo;
import com.yonyou.iuap.tree.service.TableDemoService;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.mvc.type.JsonResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import com.yonyou.iuap.common.utils.ExcelExportImportor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 说明：表TableDemo 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-31 9:36:22
 */
@Controller
@RequestMapping(value = "/table_demo")
@Api(tags = "树表table接口",description="树表table文档说明",hidden=true)
public class TableDemoController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(TableDemoController.class);

	private TableDemoService tableDemoService;

	@Autowired
	public void setTableDemoService(TableDemoService tableDemoService) {
		this.tableDemoService = tableDemoService;
	}
	/**
	 * 获取列表数据
	 * @param pageRequest
	 * @param searchParams
	 * @return
	 */
	@ApiOperation(value="查询列表数据",notes="查询树表列表数据接口说明")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRequest",value="分页数据、排序数据",dataType="PageRequest", paramType = "query"),
		@ApiImplicitParam(name="searchParams",value="查询条件",dataType="SearchParams", paramType = "query"),
	})
	@ApiResponse(response=JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams) {
		if (pageRequest.getPageSize() == 1) {
			Integer allCount = Integer.MAX_VALUE-1;
			pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
		}
		Page<TableDemo> page = this.tableDemoService.selectAllByPage(pageRequest, searchParams);
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
	@ApiOperation(value="删除数据",notes="删除树表中表数据接口说明")
	@ApiImplicitParam(name="listData",value="删除数据集合",dataType="List", paramType = "delete")
	@ApiResponse(response=JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<TableDemo> listData) throws Exception {
		this.tableDemoService.deleteBatch(listData);
		return super.buildSuccess();
	}

	/**
	 * 添加数据
	 * @param entity
	 * @return
	 */
	@ApiOperation(value="添加数据",notes="添加树表中表数据接口说明")
	@ApiImplicitParam(name="entity",value="添加数据",dataType="TableDemo", paramType = "insert")
	@ApiResponse(response=JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody TableDemo entity) {
		try {
			this.tableDemoService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@ApiOperation(value="修改数据",notes="修改树表中表数据接口说明")
	@ApiImplicitParam(name="entity",value="修改数据",dataType="TableDemo", paramType = "update")
	@ApiResponse(response=JsonResponse.class, code = 200, message = "success")
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody TableDemo entity) {
		try {
			this.tableDemoService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}
}