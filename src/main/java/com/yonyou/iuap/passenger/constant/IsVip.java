package com.yonyou.iuap.passenger.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum IsVip implements I18nEnumAble{

	No("0","否","ja.pas.enum.0004"),
	Yes("1","是","ja.pas.enum.0005");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private IsVip(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = IsVip.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(IsVip item: IsVip.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
