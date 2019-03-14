package com.yonyou.iuap.purchaseorder.constant;

import java.util.HashMap;
import java.util.Map;

import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.util.I18nEnumAble;

public enum BpmState implements I18nEnumAble{
	
	Initial("0","待确认","ja.pur.enum.0004"),
	Executing("1","执行中","ja.pur.enum.0005"),
	Finished("2","已办结","ja.pur.enum.0006"),
	Temited("3","终止","ja.pur.enum.0007");

	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private BpmState(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	public String getCode(){
		String code = BpmState.class.getSimpleName();
		return code.substring(0, 1).toLowerCase() + code.substring(1);
	}
	
	public Map<String, String> getMap(){
		Map<String, String> result = new HashMap<String, String>();
		for(BpmState item: BpmState.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
		return result;
	}
}
