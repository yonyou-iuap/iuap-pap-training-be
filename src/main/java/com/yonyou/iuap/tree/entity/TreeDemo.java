package com.yonyou.iuap.tree.entity;

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

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;

/**
 * 树结构
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TREELIST")
@Associative(fkName = "treeId")
@CodingEntity(codingField = "")
public class TreeDemo extends AbsBpmModel implements Serializable, MultiTenant, Printable {
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
		return "TREE_DEMO";
	}

	@Condition
	@Column(name = "IS_SON")
	private Integer isSon; // 是否有子节点

	public void setIsSon(Integer isSon) {
		this.isSon = isSon;
	}

	public Integer getIsSon() {
		return this.isSon;
	}

	@Transient
	private String isSonEnumValue; // 是否有子节点

	public void setIsSonEnumValue(String isSonEnumValue) {
		this.isSonEnumValue = isSonEnumValue;
	}

	public String getIsSonEnumValue() {
		return this.isSonEnumValue;
	}

	@Condition(match = Match.LIKE)
	@Column(name = "NAME")
	private String name; // 名称

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Condition(match = Match.EQ)
	@Column(name = "PARENTID")
	private String parentId; // 父节点

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return this.parentId;
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
	
	@Column(name = "CODE")
	@Condition(match = Match.IN)
	private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Transient
	private List<TreeDemo> children = new ArrayList<>(); //

	public List<TreeDemo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDemo> children) {
		this.children = children;
	}

}
