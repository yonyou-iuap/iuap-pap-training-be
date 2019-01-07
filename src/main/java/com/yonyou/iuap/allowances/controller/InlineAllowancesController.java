package com.yonyou.iuap.allowances.controller;

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

import com.yonyou.iuap.CSRFToken;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesEnumService;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;

/**
 * 说明：员工津贴记录 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-9 16:44:58
 */
@Controller
@RequestMapping(value = "/inline_allowances")
public class InlineAllowancesController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(InlineAllowancesController.class);

	private AllowancesService allowancesService;

	@Autowired
	public void setAllowancesService(AllowancesService allowancesService) {
		this.allowancesService = allowancesService;
	}
	
	@Autowired
	private StatCommonService statCommonService;
	
	private static final String MODELCODE = "Allowances";
	
	/**
	 * 批量添加
	 * @param listData
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/saveMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object saveMultiple(@RequestBody List<Allowances> listData) {
		try {
			this.allowancesService.saveMultiple(listData);
			return this.buildSuccess();
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error save database", RequestStatusEnum.FAIL_FIELD);
		}
		
	}
	/**
	 * 批量修改
	 * @param listData
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/updateMultiple", method = RequestMethod.POST)
	@ResponseBody
	public Object updateMultiple(@RequestBody List<Allowances> listData) {
		try {
			this.allowancesService.updateMultiple(listData);
			return this.buildSuccess();
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error update database", RequestStatusEnum.FAIL_FIELD);
		}
		
	}
		
	/**
	 * 删除
	 * @param listData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@CSRFToken
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
	@CSRFToken(verify = false)
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
}
