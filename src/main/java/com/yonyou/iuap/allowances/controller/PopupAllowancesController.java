package com.yonyou.iuap.allowances.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;
import com.yonyou.iuap.pap.base.i18n.MethodUtils;

/**
 * 说明：员工津贴记录 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-9 16:44:58
 */
@Controller
@RequestMapping(value = "/popup_allowances")
public class PopupAllowancesController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(PopupAllowancesController.class);
	//多语常量
	private static final String KEY1 = "ja.all.con1.0001";
    private static final String MSG1 = "查询数据异常！";
    private static final String KEY2 = "ja.all.con1.0002";
    private static final String MSG2 = "新增数据异常！";
    private static final String KEY3 = "ja.all.con1.0003";
    private static final String MSG3 = "修改数据异常！";
    private static final String KEY4 = "ja.all.con1.0004";
    private static final String MSG4 = "删除数据异常！";
    private static final String NAME = "name";
	private static final String KEY = "ja.all.con.00001";
	private static final String MESSAGE = "名称不能为空！";
	
	private AllowancesService allowancesService;

	@Autowired
	public void setAllowancesService(AllowancesService allowancesService) {
		this.allowancesService = allowancesService;
	}
	
	@Autowired
	private StatCommonService statCommonService;
	
	private static final String MODELCODE = Allowances.class.getSimpleName();
	/**
	 * 添加
	 * @param entity
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody Allowances entity) {
		try {
			 /**国际化 当前语种*/
            String localeSerial= InvocationInfoProxy.getParameter("locale_serial");
            String loacleName = MethodUtils.getDataBySerial(entity, NAME,localeSerial);
            if (StringUtils.isBlank(loacleName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
            /**国际化 验证默认语种*/
            String defaultSerial= InvocationInfoProxy.getParameter("default_serial");
            String defaultName = MethodUtils.getDataBySerial(entity, NAME,defaultSerial);
            if (StringUtils.isBlank(defaultName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
            /**国际化 验证简体中文**/
            String simpleChineseName = MethodUtils.getDataBySerial(entity, NAME,"");
            if (StringUtils.isBlank(simpleChineseName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
			allowancesService.insertSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY2, MSG2), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY2, MSG2), RequestStatusEnum.FAIL_FIELD);
		}
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	@CSRFToken
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody Allowances entity) {
		try {
			/**国际化 当前语种*/
            String localeSerial= InvocationInfoProxy.getParameter("locale_serial");
            String loacleName = MethodUtils.getDataBySerial(entity, NAME,localeSerial);
            if (StringUtils.isBlank(loacleName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
            /**国际化 验证默认语种*/
            String defaultSerial= InvocationInfoProxy.getParameter("default_serial");
            String defaultName = MethodUtils.getDataBySerial(entity, NAME,defaultSerial);
            if (StringUtils.isBlank(defaultName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
            /**国际化 验证简体中文**/
            String simpleChineseName = MethodUtils.getDataBySerial(entity, NAME,"");
            if (StringUtils.isBlank(simpleChineseName)) {
            	return this.buildError("msg", MessageSourceUtil.getMessage(KEY, MESSAGE), RequestStatusEnum.FAIL_FIELD);
            }
			allowancesService.updateSelective(entity);
			return this.buildSuccess(entity);
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY3, MSG3), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY3, MSG3), RequestStatusEnum.FAIL_FIELD);
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
			HttpServletResponse response) {
		try {
			this.allowancesService.deleteBatch(listData);
			return super.buildSuccess();
		} catch (Exception exp) {
			logger.error(MessageSourceUtil.getMessage(KEY4, MSG4), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY4, MSG4), RequestStatusEnum.FAIL_FIELD);
		}
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
			logger.error(MessageSourceUtil.getMessage(KEY1, MSG1), exp);
			return this.buildError("msg", MessageSourceUtil.getMessage(KEY1, MSG1), RequestStatusEnum.FAIL_FIELD);
		}
	}
}
