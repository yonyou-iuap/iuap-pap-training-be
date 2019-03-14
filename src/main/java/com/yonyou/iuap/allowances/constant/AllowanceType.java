package com.yonyou.iuap.allowances.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum AllowanceType implements I18nEnumAble{

	ComputerAssistance("1","电脑补助","ja.all.enum.0005"),
	AccommodationSubsidy("2","住宿补助","ja.all.enum.0006"),
	TransportationAssistance("3","交通补助","ja.all.enum.0007");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
		
	private AllowanceType(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = AllowanceType.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(AllowanceType item: AllowanceType.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
