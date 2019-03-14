package com.yonyou.iuap.passenger.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum Grade implements I18nEnumAble {
	Junior("1","初级会员","ja.pas.enum.0001"),
	Intermediate("2","中级会员","ja.pas.enum.0002"),
	Premium("3","高级会员","ja.pas.enum.0003");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private Grade(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = Grade.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(Grade item: Grade.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
