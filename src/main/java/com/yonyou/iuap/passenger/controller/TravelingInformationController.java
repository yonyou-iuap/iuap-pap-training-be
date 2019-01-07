package com.yonyou.iuap.passenger.controller;

import java.util.List;

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
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import com.yonyou.iuap.passenger.service.TravelingInformationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明：乘车预定信息 基础Controller——提供数据增、删、改、查、导入导出等rest接口
 * 
 * @date 2018-10-25 20:11:56
 */
@Controller
@RequestMapping(value = "/traveling_information")
public class TravelingInformationController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(TravelingInformationController.class);

	private TravelingInformationService travelingInformationService;

	@Autowired
	public void setTravelingInformationService(TravelingInformationService travelingInformationService) {
		this.travelingInformationService = travelingInformationService;
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
			Page<TravelingInformation> page = this.travelingInformationService.selectAllByPage(pageRequest, searchParams);
			return this.buildSuccess(page);
		} catch (Exception exp) {
			logger.error("exp", exp);
			return this.buildError("msg", "Error query database", RequestStatusEnum.FAIL_FIELD);
		}
		
	}
	
	/**
	 * 添加数据
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(@RequestBody TravelingInformation entity) {
		try {
			entity = this.travelingInformationService.insertSelective(entity);
			TravelingInformation travelingInformation = this.travelingInformationService.findById(entity.getId());
			return this.buildSuccess(travelingInformation);
		} catch (Exception exp) {
			return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
		}
	}

	/**
	 * 修改数据
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelective(@RequestBody TravelingInformation entity) {
		try {
			entity = this.travelingInformationService.updateSelective(entity);
			TravelingInformation travelingInformation = this.travelingInformationService.findById(entity.getId());
			return this.buildSuccess(travelingInformation);
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
	public Object deleteBatch(@RequestBody List<TravelingInformation> listData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.travelingInformationService.deleteBatch(listData);
		return super.buildSuccess();
	}
}