package com.yonyou.iuap.purchaseorder.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.bpm.service.GenericBpmService;
import com.yonyou.iuap.bpm.pojo.BPMFormJSON;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.purchaseorder.dao.PurchaseOrderMapper;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;

@Service
public class PurchaseOrderBpmService extends GenericBpmService<PurchaseOrder> {

	private PurchaseOrderMapper purchaseOrderMapper;

	@Autowired
	public void setPurchaseOrderMapper(PurchaseOrderMapper purchaseOrderMapper) {
		this.purchaseOrderMapper = purchaseOrderMapper;
		super.setIbatisMapperEx(purchaseOrderMapper);
	}

	@Override
	public BPMFormJSON buildBPMFormJSON(String processDefineCode, PurchaseOrder entity) {
		try {
			BPMFormJSON bpmform = new BPMFormJSON();
			bpmform.setProcessDefinitionKey(processDefineCode);
			String userName = InvocationInfoProxy.getUsername();
			try {
				userName = URLDecoder.decode(userName, "utf-8");
				userName = URLDecoder.decode(userName, "utf-8");
			} catch (UnsupportedEncodingException e) {
				userName = InvocationInfoProxy.getUsername();
			}
			// title
			String title = userName + "提交的【一主一子】单据,单号是" + entity.getOrderCode() + ", 请审批";
			bpmform.setTitle(title);
			// 实例名
			bpmform.setFunCode("masterdetail-one");
			// 单据id
			bpmform.setFormId(entity.getId().toString());
			// 单据号
			bpmform.setBillNo(entity.getOrderCode());
			// 制单人
			bpmform.setBillMarker(InvocationInfoProxy.getUserid());
			// 其他变量
			bpmform.setOtherVariables(buildEntityVars(entity));
			// 单据url
			bpmform.setFormUrl("/iuap-pap-training-fe/masterdetail-one/#/order?btnFlag=2&search_id=" + entity.getId()); // 单据url
			// 流程实例名称
			bpmform.setProcessInstanceName(title); // 流程实例名称
			// 流程审批后，执行的业务处理类(controller对应URI前缀)
			bpmform.setServiceClass("/iuap-pap-training-be/purchase_order");// 流程审批后，执行的业务处理类(controller对应URI前缀)
			// 设置单据打开类型 uui/react
			bpmform.setFormType(BPMFormJSON.FORMTYPE_REACT);
			return bpmform;
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
