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
import com.yonyou.iuap.passenger.entity.Passenger;
import com.yonyou.iuap.passenger.service.PassengerService;
/**
 * 说明：Passenger员工乘客信息 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-25 20:12:16
 */
@Controller
@RequestMapping(value = "/passenger")
public class PassengerController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(PassengerController.class);

	private PassengerService passengerService;

	@Autowired
	public void setPassengerService(PassengerService passengerService) {
		this.passengerService = passengerService;
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
		Page<Passenger> page = this.passengerService.selectAllByPage(pageRequest, searchParams);
		return this.buildSuccess(page);
	}
	
	/**
	 * 添加数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/insertSelective")
	@ResponseBody
	public Object insertSelective(@RequestBody Passenger entity) {
		try {
			entity = this.passengerService.insertSelective(entity);
			Passenger passenger = this.passengerService.findById(entity.getId());
			return this.buildSuccess(passenger);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateSelective")
	@ResponseBody
	public Object updateSelective(@RequestBody Passenger entity) {
		try {
			entity = this.passengerService.updateSelective(entity);
			Passenger passenger = this.passengerService.findById(entity.getId());
			return this.buildSuccess(passenger);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
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
	public Object deleteBatch(@RequestBody List<Passenger> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.passengerService.deleteBatch(listData);
		return super.buildSuccess();
	}
	
	
}