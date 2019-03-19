package com.yonyou.iuap.passenger.entity;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.multitenant.entity.MultiTenant;

import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.passenger.constant.PayStatusEnum;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.math.BigDecimal;

/**
 * 乘车预定信息
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TRAVELING_INFORMATION")
@CodingEntity(codingField = "")
public class TravelingInformation extends AbsBpmModel implements Serializable, MultiTenant, Printable {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(Serializable id) {
		this.id = id.toString();
		super.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getMainBoCode() {
		return "TRAVELING_INFORMATION";
	}

	@Condition
	@Column(name = "COST")
	private BigDecimal cost; // 费用

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	@Condition
	@Column(name = "LINE")
	private String line; // 乘车线路

	public void setLine(String line) {
		this.line = line;
	}

	public String getLine() {
		return this.line;
	}

	@Condition
	@Column(name = "STATION_END")
	private String stationEnd; // 下车站点

	public void setStationEnd(String stationEnd) {
		this.stationEnd = stationEnd;
	}

	public String getStationEnd() {
		return this.stationEnd;
	}

	@Condition
	@Column(name = "PASSENGER_ID")
	private String passengerId; // 员工编号

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerId() {
		return this.passengerId;
	}

	@Condition
	@Column(name = "REMARK")
	private String remark; // 备注

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
	@EnumValue(value=PayStatusEnum.class,des="payStatusEnumValue")
	@Condition
	@Column(name = "PAY_STATUS")
	private Integer payStatus; // 支付状态

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	@Transient
	private String payStatusEnumValue; // 支付状态

	public void setPayStatusEnumValue(String payStatusEnumValue) {
		this.payStatusEnumValue = payStatusEnumValue;
	}

	public String getPayStatusEnumValue() {
		return this.payStatusEnumValue;
	}

	@Condition
	@Column(name = "STATION_BEGIN")
	private String stationBegin; // 上车站点

	public void setStationBegin(String stationBegin) {
		this.stationBegin = stationBegin;
	}

	public String getStationBegin() {
		return this.stationBegin;
	}

	@Override
	public String getBpmBillCode() {
		return DateUtil.format(new Date(), "yyyyMMddHHmmss" + new Random().nextInt(10));
	}

	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;

	public String getTenantid() {
		return this.tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
	@Column(name="TRAVEL_TIME")
	@Condition
	private String travelTime;

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	
	
	
}
