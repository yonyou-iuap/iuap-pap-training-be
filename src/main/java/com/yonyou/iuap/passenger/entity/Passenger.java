package com.yonyou.iuap.passenger.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.allowances.constant.SexEnum;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.entity.annotation.CodingField;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.multitenant.entity.MultiTenant;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import com.yonyou.iuap.passenger.constant.GradeEnum;
import com.yonyou.iuap.passenger.constant.IsVipEnum;

import cn.hutool.core.date.DateUtil;

/**
 * Passenger乘客信息
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_PASSENGER")
@Associative(fkName = "passengerId")
@CodingEntity(codingField = "code")
public class Passenger extends AbsBpmModel implements Serializable, MultiTenant, Printable {
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
		return "PASSENGER";
	}

	@Condition(match = Match.LIKE)
	@Column(name = "CODE")
	@CodingField(code = "passenger")
	private String code; // 乘客编号

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	@Condition(match = Match.LIKE)
	@Column(name = "PHONE")
	private String phone; // 手机号

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}
	
	@EnumValue(value=SexEnum.class,des="sexEnumValue")
	@Condition
	@Column(name = "SEX")
	private Integer sex; // 乘客性别

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

	@Transient
	private String sexEnumValue; // 乘客性别

	public void setSexEnumValue(String sexEnumValue) {
		this.sexEnumValue = sexEnumValue;
	}

	public String getSexEnumValue() {
		return this.sexEnumValue;
	}
	
	@EnumValue(value=GradeEnum.class,des="gradeEnumValue")
	@Condition
	@Column(name = "GRADE")
	private Integer grade; // 会员等级

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getGrade() {
		return this.grade;
	}

	@Transient
	private String gradeEnumValue; // 会员等级

	public void setGradeEnumValue(String gradeEnumValue) {
		this.gradeEnumValue = gradeEnumValue;
	}

	public String getGradeEnumValue() {
		return this.gradeEnumValue;
	}

	@Condition(match = Match.LIKE)
	@Column(name = "NAME")
	private String name; // 乘客姓名

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Condition
	@Column(name = "DEPT")
	@Reference(code = "newdept", srcProperties = { "refname" }, desProperties = { "deptName" })
	private String dept; // 所属部门

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDept() {
		return this.dept;
	}

	@Transient
	private String deptName; // 所属部门

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return this.deptName;
	}
	@EnumValue(value=IsVipEnum.class,des="isVipEnumValue")
	@Condition
	@Column(name = "IS_VIP")
	private boolean isVip; // 是否会员

	public void setIsVip(boolean isVip) {
		this.isVip = isVip;
	}

	public boolean getIsVip() {
		return this.isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	@Transient
	private String isVipEnumValue; // 是否会员

	public void setIsVipEnumValue(String isVipEnumValue) {
		this.isVipEnumValue = isVipEnumValue;
	}

	public String getIsVipEnumValue() {
		return this.isVipEnumValue;
	}

	@Condition
	@Column(name = "EXPIRATION_DATE")
	private String expirationDate; // 会员到期日期

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getExpirationDate() {
		return this.expirationDate;
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
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME2")
	private String name2; // 乘客姓名2
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME3")
	private String name3; // 乘客姓名3
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME4")
	private String name4; // 乘客姓名4
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME5")
	private String name5; // 乘客姓名5
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME6")
	private String name6; // 乘客姓名6

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}
	
}
