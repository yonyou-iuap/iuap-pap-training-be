package com.yonyou.iuap.purchaseorder.entity;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.multitenant.entity.MultiTenant;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.baseservice.support.generator.Strategy;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.entity.annotation.CodingField;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;

/**
 * 请购单详情表_物料表
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_PURCHASE_ORDER_DETAIL")
public class PurchaseOrderDetail extends AbsBpmModel implements Serializable, MultiTenant, Printable {

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
		return "PURCHASE_ORDER_DETAIL";
	}

	@Condition
	@Column(name = "DETAIL_NAME")

	private String detailName; // 物料名称

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailName() {
		return this.detailName;
	}

	@Condition
	@Column(name = "ORDER_ID")

	private String orderId; // 请购单ID

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	@Condition
	@Column(name = "DETAIL_MODEL")
	private String detailModel; // 物料型号

	public void setDetailModel(String detailModel) {
		this.detailModel = detailModel;
	}

	public String getDetailModel() {
		return this.detailModel;
	}

	@Condition
	@Column(name = "DETAIL_DATE")

	private String detailDate; // 需求日期

	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}

	public String getDetailDate() {
		return this.detailDate;
	}

	@Condition
	@Column(name = "DETAIL_COUNT")

	private Integer detailCount; // 物料数量

	public void setDetailCount(Integer detailCount) {
		this.detailCount = detailCount;
	}

	public Integer getDetailCount() {
		return this.detailCount;
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

}
