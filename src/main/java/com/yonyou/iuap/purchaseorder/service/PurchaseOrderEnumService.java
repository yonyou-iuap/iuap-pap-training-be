package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;

@Service
public class PurchaseOrderEnumService implements QueryFeatureExtension<PurchaseOrder> {

	private static Map<String, String> orderTypeMap = new HashMap<String, String>();
	private static Map<String, String> bpmStateMap = new HashMap<String, String>();
	static {
		orderTypeMap.put("1", MessageSourceUtil.getMessage("ja.pur.enum.0001", "普通采购"));
		orderTypeMap.put("2", MessageSourceUtil.getMessage("ja.pur.enum.0002","委托代销"));
		orderTypeMap.put("3", MessageSourceUtil.getMessage("ja.pur.enum.0003","直运采购"));
		
		bpmStateMap.put("0", MessageSourceUtil.getMessage("ja.pur.enum.0004","待确认"));
		bpmStateMap.put("1", MessageSourceUtil.getMessage("ja.pur.enum.0005","执行中"));
		bpmStateMap.put("2", MessageSourceUtil.getMessage("ja.pur.enum.0006","已办结"));
		bpmStateMap.put("3", MessageSourceUtil.getMessage("ja.pur.enum.0007","终止"));

	}

	@Override
	public List<PurchaseOrder> afterListQuery(List<PurchaseOrder> list) {
		List<PurchaseOrder> resultList = new ArrayList<PurchaseOrder>();
		for (PurchaseOrder entity : list) {
			if (entity.getOrderType() != null) {
				String value = orderTypeMap.get(entity.getOrderType().toString());
				entity.setOrderTypeEnumValue(value);
			}
			if (entity.getBpmState() != null) {
				String value = bpmStateMap.get(entity.getBpmState().toString());
				entity.setBpmStateEnumValue(value);
			}
			resultList.add(entity);
		}

		return resultList;
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
