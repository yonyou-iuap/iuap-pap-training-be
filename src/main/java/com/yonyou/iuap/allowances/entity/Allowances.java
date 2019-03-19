package com.yonyou.iuap.allowances.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.allowances.constant.AllowanceTypeEnum;
import com.yonyou.iuap.allowances.constant.ExdeedsEnum;
import com.yonyou.iuap.allowances.constant.MonthEnum;
import com.yonyou.iuap.allowances.constant.PickTypeEnum;
import com.yonyou.iuap.allowances.constant.SexEnum;
import com.yonyou.iuap.baseservice.bpm.entity.AbsBpmModel;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.entity.annotation.CodingField;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.multitenant.entity.MultiTenant;
import com.yonyou.iuap.baseservice.print.entity.Printable;
import com.yonyou.iuap.baseservice.statistics.support.StatFunctions;
import com.yonyou.iuap.baseservice.statistics.support.StatisticsField;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;

/**
 * 员工津贴记录N
 * 
 * @date 2018年11月05日 下午02点23分42秒
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_ALLOWANCES")
@CodingEntity(codingField = "code")
public class Allowances extends AbsBpmModel implements Serializable, Printable, MultiTenant {
	
	@Id
	@GeneratedValue
	@Condition
	@StatisticsField(functions = { StatFunctions.count })
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
		return "ALLOWANCES";
	}

	@Transient
	private String deptName; // 部门

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	@Condition(match = Match.LIKE)
	@Column(name = "CODE")
	@CodingField(code = "iuapd_asval")
	private String code; // 员工编号

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	@Condition
	@Column(name = "SERVICE_YEARS_COMPANY")
	private Integer serviceYearsCompany; // 司龄

	public void setServiceYearsCompany(Integer serviceYearsCompany) {
		this.serviceYearsCompany = serviceYearsCompany;
	}

	public Integer getServiceYearsCompany() {
		return this.serviceYearsCompany;
	}

	@Condition
	@Column(name = "PICK_TIME")
	private String pickTime; // 领取时间

	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}

	public String getPickTime() {
		return this.pickTime;
	}

	@Condition
	@Column(name = "POST_LEVEL")
	@Reference(code = "post_level", srcProperties = { "code" }, desProperties = { "levelName" })
	private String postLevel; // 职级

	

	public String getPostLevel() {
		return postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	@Condition(match = Match.EQ)
	@Column(name = "YEAR")
	private String year; // 年份

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return this.year;
	}
	@EnumValue(value=SexEnum.class,des="sexEnumValue")
	@Condition
	@Column(name = "SEX")
	private Integer sex; // 员工性别

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}
	
	
	@Transient
	private String sexEnumValue; // 员工性别

	public void setSexEnumValue(String sexEnumValue) {
		this.sexEnumValue = sexEnumValue;
	}

	public String getSexEnumValue() {
		return this.sexEnumValue;
	}

	@Condition
	@Column(name = "ALLOWANCE_STANDARD")
	private BigDecimal allowanceStandard; // 补贴标准

	public void setAllowanceStandard(BigDecimal allowanceStandard) {
		this.allowanceStandard = allowanceStandard;
	}

	public BigDecimal getAllowanceStandard() {
		return this.allowanceStandard;
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

	@Transient
	private String levelName; // 职级

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelName() {
		return this.levelName;
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
	@EnumValue(value=ExdeedsEnum.class,des="exdeedsEnumValue")
	@Condition(match = Match.EQ)
	@Column(name = "EXDEEDS")
	private Integer exdeeds; // 是否超标

	public void setExdeeds(Integer exdeeds) {
		this.exdeeds = exdeeds;
	}

	public Integer getExdeeds() {
		return this.exdeeds;
	}
	
	@Transient
	private String exdeedsEnumValue; // 是否超标

	public void setExdeedsEnumValue(String exdeedsEnumValue) {
		this.exdeedsEnumValue = exdeedsEnumValue;
	}

	public String getExdeedsEnumValue() {
		return this.exdeedsEnumValue;
	}

	@Condition
	@Column(name = "ALLOWANCE_ACTUAL")
	@StatisticsField(functions = { StatFunctions.sum })
	private BigDecimal allowanceActual; // 实际补贴

	public void setAllowanceActual(BigDecimal allowanceActual) {
		this.allowanceActual = allowanceActual;
	}

	public BigDecimal getAllowanceActual() {
		return this.allowanceActual;
	}
	@EnumValue(value = AllowanceTypeEnum.class,des="allowanceTypeEnumValue")
	@Condition
	@Column(name = "ALLOWANCE_TYPE")
	private Integer allowanceType; // 补贴类别

	public void setAllowanceType(Integer allowanceType) {
		this.allowanceType = allowanceType;
	}

	public Integer getAllowanceType() {
		return this.allowanceType;
	}
	
	@Transient
	private String allowanceTypeEnumValue; // 补贴类别

	public void setAllowanceTypeEnumValue(String allowanceTypeEnumValue) {
		this.allowanceTypeEnumValue = allowanceTypeEnumValue;
	}

	public String getAllowanceTypeEnumValue() {
		return this.allowanceTypeEnumValue;
	}
	@EnumValue(value = MonthEnum.class,des="monthEnumValue")
	@Condition(match = Match.EQ)
	@Column(name = "MONTH")
	private Integer month; // 月份

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getMonth() {
		return this.month;
	}
	
	@Transient
	private String monthEnumValue; // 月份

	public void setMonthEnumValue(String monthEnumValue) {
		this.monthEnumValue = monthEnumValue;
	}

	public String getMonthEnumValue() {
		return this.monthEnumValue;
	}
	@EnumValue(value = PickTypeEnum.class ,des="pickTypeEnumValue")
	@Condition
	@Column(name = "PICK_TYPE")
	private Integer pickType; // 领取方式

	public void setPickType(Integer pickType) {
		this.pickType = pickType;
	}

	public Integer getPickType() {
		return this.pickType;
	}
	
	@Transient
	private String pickTypeEnumValue; // 领取方式

	public void setPickTypeEnumValue(String pickTypeEnumValue) {
		this.pickTypeEnumValue = pickTypeEnumValue;
	}

	public String getPickTypeEnumValue() {
		return this.pickTypeEnumValue;
	}

	@Condition(match = Match.LIKE)
	@Column(name = "NAME")
	private String name; // 员工姓名

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Condition
	@Column(name = "SERVICE_YEARS")
	private Integer serviceYears; // 工龄

	public void setServiceYears(Integer serviceYears) {
		this.serviceYears = serviceYears;
	}

	public Integer getServiceYears() {
		return this.serviceYears;
	}

	@Condition
	@Column(name = "APPLY_TIME")
	private String applyTime; // 申请时间

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	@Override
	public String getBpmBillCode() {
		return getCode();
	}

	@Column(name = "TENANT_ID")
	@Condition(match = Match.EQ)
	private String tenantid;

	public String getTenantid() {
		return this.tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
	@Condition(match = Match.LIKE)
	@Column(name = "NAME2")
	private String name2; // 员工姓名2
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME3")
	private String name3; // 员工姓名3
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME4")
	private String name4; // 员工姓名4
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME5")
	private String name5; // 员工姓名5
	
	@Condition(match = Match.LIKE)
	@Column(name = "NAME6")
	private String name6; // 员工姓名6

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
