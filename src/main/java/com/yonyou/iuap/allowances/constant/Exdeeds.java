package com.yonyou.iuap.allowances.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum Exdeeds implements I18nEnumAble {
	
	NotExceeded("0","未超标","ja.all.enum.0003"),
	ExceededStandard("1","超标","ja.all.enum.0004");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private Exdeeds(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	@Override
	public String getCode() {
		String code = Exdeeds.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}

	@Override
	public Map<String, String> getMap() {
		Map<String, String> result = new HashMap<String, String>();
		for(Exdeeds item: Exdeeds.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
	
	
}
