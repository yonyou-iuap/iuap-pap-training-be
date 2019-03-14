package com.yonyou.iuap.allowances.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum Month implements I18nEnumAble{
		
	January("1","一月","ja.all.enum.0008"),
	February("2","二月","ja.all.enum.0009"),
	March("3","三月","ja.all.enum.0010"),
	April("4","四月","ja.all.enum.0011"),
	May("5","五月","ja.all.enum.0012"),
	June("6","六月","ja.all.enum.0013"),
	July("7","七月","ja.all.enum.0014"),
	August("8","八月","ja.all.enum.0015"),
	September("9","九月","ja.all.enum.0016"),
	October("10","十月","ja.all.enum.0017"),
	November("11","十一月","ja.all.enum.0018"),
	December("12","十二月","ja.all.enum.0019");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private Month(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	@Override
	public String getCode() {
		String code = Month.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}

	@Override
	public Map<String, String> getMap() {
		Map<String, String> result = new HashMap<String, String>();
		for(Month item: Month.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
	
}
