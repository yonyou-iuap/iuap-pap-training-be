package com.yonyou.iuap.model.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum ModelType implements I18nEnumAble{
	
	Test1("1","测试1","ja.model.enum.0001"),
	Test2("2","测试2","ja.model.enum.0002");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private ModelType(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = ModelType.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(ModelType item: ModelType.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
