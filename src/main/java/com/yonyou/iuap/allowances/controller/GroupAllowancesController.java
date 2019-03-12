package com.yonyou.iuap.allowances.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesEnumService;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;

/**
 * 说明：员工津贴记录 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-9 16:44:58
 */
@Controller
@RequestMapping(value = "/group_allowances")
public class GroupAllowancesController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(GroupAllowancesController.class);
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
    private static final String MSG1 = "查询数据异常";
	
	private AllowancesService allowancesService;

	@Autowired
	public void setAllowancesService(AllowancesService allowancesService) {
		this.allowancesService = allowancesService;
	}
	
	@Autowired
	private StatCommonService statCommonService;
	
	private static final String MODELCODE = Allowances.class.getSimpleName();
	
	/**
	 * 多过滤 多排序
	 * @param pageRequest
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(PageRequest pageRequest,@RequestBody Map<String, Object> searchMap) {
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
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
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
		try { 
			SearchParams searchParams = new SearchParams();
		    searchParams.setSearchMap(searchMap);
		    if (pageRequest.getPageSize() == 1) {
				Integer allCount = Integer.MAX_VALUE-1;
				pageRequest = new PageRequest(pageRequest.getPageNumber(), allCount, pageRequest.getSort());
			}
		    Page<Map> page = this.statCommonService.selectAllByPage(pageRequest, searchParams, MODELCODE);
		    AllowancesEnumService.fillDynamicList( page.getContent());
		    return buildSuccess(page);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 行过滤
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/distinct", method = RequestMethod.POST)
	@ResponseBody
	public Object distinct(@RequestBody Map<String, Object> searchMap) {
		try {
			SearchParams searchParams = new SearchParams();
			Map<String, Object> resultMap = new HashMap<>();
		    searchParams.setSearchMap(searchMap);
		    List<Map> list = this.statCommonService.findDistinct(searchParams, MODELCODE);
		    AllowancesEnumService.fillDynamicList(list);
	        resultMap.put("content", list);
		    return buildSuccess(list);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
}
