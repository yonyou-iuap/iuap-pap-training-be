package com.yonyou.iuap.allowances.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesEnumService;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.persistence.support.CustomSelectListable;
import com.yonyou.iuap.baseservice.persistence.support.SimpleCustomSelectList;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.baseservice.statistics.support.ParamProcessResult;
import com.yonyou.iuap.baseservice.statistics.util.SearchParamUtil;
import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;

/**
 * 说明：员工津贴记录 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-9 16:44:58
 */
@Controller
@RequestMapping(value = "/allowances")
public class AllowancesController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(AllowancesController.class);

	private AllowancesService allowancesService;

	@Autowired
	public void setAllowancesService(AllowancesService allowancesService) {
		this.allowancesService = allowancesService;
	}
	
	@Autowired
	private StatCommonService statCommonService;
	
	private static final String MODELCODE = "Allowances";
	/**
	 * 添加
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody Allowances entity) {
		try {
			allowancesService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody Allowances entity) {
		try {
			allowancesService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}
	
	/**
	 * 批量添加
	 * @param listData
	 * @return
	 */
	@RequestMapping(value = "/saveMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object saveMultiple(@RequestBody List<Allowances> listData) {
		this.allowancesService.saveMultiple(listData);
		return this.buildSuccess();
	}
	/**
	 * 批量修改
	 * @param listData
	 * @return
	 */
	@RequestMapping(value = "/updateMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object updateMultiple(@RequestBody List<Allowances> listData) {
		this.allowancesService.updateMultiple(listData);
		return this.buildSuccess();
	}
	
	
	/**
	 * 删除
	 * @param listData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBatch(@RequestBody List<Allowances> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.allowancesService.deleteBatch(listData);
		return super.buildSuccess();
	}
	/**
	 * 下载模板
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/excelTemplateDownload", method = { RequestMethod.GET })
	@ResponseBody
	public Object excelTemplateDownload(HttpServletRequest request, HttpServletResponse response) {
		String name = "ALLOWANCES";
		try {
			ExcelExportImportor.downloadExcelTemplate(response, getImportHeadInfo(), name, name);
		} catch (Exception e) {
			logger.error("Excel模版下载失败", e);
		}
		return super.buildSuccess("Excel模版下载成功");
	}
	
	private static Map<String, String> getImportHeadInfo() {
		Map<String, String> importMap = new HashMap<>();
		importMap.put("code", "员工编号");
		importMap.put("serviceYearsCompany", "司龄");
		importMap.put("pickTime", "领取时间");
		importMap.put("level", "职级");
		importMap.put("year", "年份");
		importMap.put("sex", "员工性别");
		importMap.put("allowanceStandard", "补贴标准");
		importMap.put("remark", "备注");
		importMap.put("dept", "所属部门");
		importMap.put("exdeeds", "是否超标");
		importMap.put("allowanceActual", "实际补贴");
		importMap.put("allowanceType", "补贴类别");
		importMap.put("month", "月份");
		importMap.put("pickType", "领取方式");
		importMap.put("name", "员工姓名");
		importMap.put("serviceYears", "工龄");
		importMap.put("applyTime", "申请时间");
		return importMap;
	}
	/**
	 * 多过滤 多排序
	 * @param pageRequest
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(PageRequest pageRequest, @RequestBody Map<String, Object> searchMap) {
		try {
			SearchParams searchParams = new SearchParams();
			searchParams.setSearchMap(searchMap);
		    if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE-1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
	    	Page<Map> page = this.statCommonService.selectFieldsByPage(pageRequest, searchParams, MODELCODE);
	    	AllowancesEnumService.fillDynamicList( page.getContent());
	    	return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error querying database", RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 分组
	 * @param pageRequest
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/listByGroup", method = RequestMethod.POST)
	@ResponseBody
	public Object listByGroup(PageRequest pageRequest, @RequestBody Map<String, Object> searchMap) {
	    SearchParams searchParams = new SearchParams();
	    searchParams.setSearchMap(searchMap);
	    if (pageRequest.getPageSize() == 1) {
			Integer allCount = Integer.MAX_VALUE-1;
			pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
		}
	    Page<Map> page = this.statCommonService.selectAllByPage(pageRequest, searchParams, MODELCODE);
	    AllowancesEnumService.fillDynamicList( page.getContent());
	    return buildSuccess(page);
	}
	/**
	 * 行过滤
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/distinct", method = RequestMethod.POST)
	@ResponseBody
	public Object distinct(@RequestBody Map<String, Object> searchMap) {
		SearchParams searchParams = new SearchParams();
		Map<String, Object> resultMap = new HashMap<>();
	    searchParams.setSearchMap(searchMap);
	    /*CustomSelectListable<Allowances> calling = new SimpleCustomSelectList<Allowances>(searchParams,null){
			@Override
			public List<Allowances> doCustomSelectList() {
				List<Map> list = statCommonService.findDistinct(searchParams, modelCode);
				 List<Allowances> result = new ArrayList<>();
				 for(Map item :list) {
					Allowances entity = JSON.parseObject(JSONObject.toJSONString(item), Allowances.class, new Feature[] { Feature.IgnoreNotMatch });;
					result.add(entity);
				 }
				return result;
			}
	    };
	    List<Allowances>  list = allowancesService.customSelectListWithFeatures(calling );*/
	    List<Map> list = this.statCommonService.findDistinct(searchParams, MODELCODE);
	    AllowancesEnumService.fillDynamicList(list);
        resultMap.put("content", list);
	    return buildSuccess(list);
	}
}
