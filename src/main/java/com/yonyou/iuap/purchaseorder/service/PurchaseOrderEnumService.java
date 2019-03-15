package com.yonyou.iuap.purchaseorder.service;

import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class PurchaseOrderEnumService implements QueryFeatureExtension<PurchaseOrder> {

	@SuppressWarnings(value = { "unchecked" })
	@Override
	public List<PurchaseOrder> afterListQuery(List<PurchaseOrder> list) {
		return I18nEnumUtil.i18nEnumEntityKeyToValue(list, I18nEnumUtil.getPurchaseOrderI18nEnum());
	}
	
	@SuppressWarnings(value = { "rawtypes" })
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
