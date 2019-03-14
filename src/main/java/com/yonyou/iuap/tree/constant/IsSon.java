package com.yonyou.iuap.tree.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum IsSon implements I18nEnumAble{
	
	Vanish("1","没有","ja.tree.enum.0001"),
	Exist("2","中级会员","ja.tree.enum.0002");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private IsSon(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = IsSon.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(IsSon item: IsSon.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
