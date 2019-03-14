package com.yonyou.iuap.purchaseorder.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum OrderType implements I18nEnumAble {

	GeneralPurchase("1", "普通采购", "ja.pur.enum.0001"),
	Consignment("2", "委托代销", "ja.pur.enum.0002"),
	DirectShipping("3","直运采购", "ja.pur.enum.0003");

	private String key;

	private String value;

	private String i18nKey;

	private OrderType(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode() {
		String code = OrderType.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}

	public Map<String, String> getMap() {
		Map<String, String> result = new HashMap<String, String>();
		for (OrderType item : OrderType.values()) {
			result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
