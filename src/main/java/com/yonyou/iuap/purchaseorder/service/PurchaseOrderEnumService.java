package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.i18n.MethodUtils;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class PurchaseOrderEnumService implements QueryFeatureExtension<PurchaseOrder> {

	@Override
	public List<PurchaseOrder> afterListQuery(List<PurchaseOrder> list) {
		List<PurchaseOrder> resultList = new ArrayList<>();
		for (PurchaseOrder entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getPurchaseOrderI18nEnum()) {
				Object valueObj = MethodUtils.getter(entity,i18nEnumAble.getCode());
				if(valueObj != null){
					String value = i18nEnumAble.getMap().get(valueObj.toString());
					MethodUtils.setter(entity, i18nEnumAble.getCode()+"EnumValue", value, String.class);
				}
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
