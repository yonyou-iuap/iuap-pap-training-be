package com.yonyou.iuap.passenger.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum PayStatus implements I18nEnumAble{
	
	NotPaid("1","未支付","ja.pas.enum.0006"),
	Paid("2","已支付","ja.pas.enum.0007");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private PayStatus(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = PayStatus.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(PayStatus item: PayStatus.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
	
}
