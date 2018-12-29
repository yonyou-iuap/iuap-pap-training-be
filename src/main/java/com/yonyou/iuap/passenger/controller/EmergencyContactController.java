package com.yonyou.iuap.passenger.controller;

import java.util.List;

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

import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.passenger.entity.EmergencyContact;
import com.yonyou.iuap.passenger.service.EmergencyContactService;

/**
 * 说明：紧急联系人 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-25 20:11:52
 */
@Controller
@RequestMapping(value = "/emergency_contact")
public class EmergencyContactController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(EmergencyContactController.class);

	private EmergencyContactService emergencyContactService;

	@Autowired
	public void setEmergencyContactService(EmergencyContactService emergencyContactService) {
		this.emergencyContactService = emergencyContactService;
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
		Page<EmergencyContact> page = this.emergencyContactService.selectAllByPage(pageRequest, searchParams);
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
	public Object deleteBatch(@RequestBody List<EmergencyContact> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.emergencyContactService.deleteBatch(listData);
		return super.buildSuccess();
	}

	/**
	 * 添加数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody EmergencyContact entity) {
		try {
			entity = this.emergencyContactService.insertSelective(entity);
			EmergencyContact emergencyContact = emergencyContactService.findById(entity.getId());
			return this.buildSuccess(emergencyContact);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody EmergencyContact entity) {
		try {
			entity = this.emergencyContactService.updateSelective(entity);
			EmergencyContact emergencyContact = emergencyContactService.findById(entity.getId());
			return this.buildSuccess(emergencyContact);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}
}