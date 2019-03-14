package com.yonyou.iuap.allowances.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.i18n.MethodUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

@Service
public class AllowancesEnumService implements QueryFeatureExtension<Allowances> {
	
	@Override
	public List<Allowances> afterListQuery(List<Allowances> list) {
		List<Allowances> resultList = new ArrayList<Allowances>();
		for (Allowances entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getAllowancesI18nEnum()) {
				Object valueObj = MethodUtils.getter(entity,i18nEnumAble.getCode());
				if(valueObj != null){
					String value = i18nEnumAble.getMap().get(valueObj.toString());
					MethodUtils.setter(entity, i18nEnumAble.getCode()+"EnumValue", value, String.class);
				}
			}
			resultList.add(entity);
		}
		return resultList;
	}

	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}	
	/**
	 * 动态查询数据 枚举值key-to-value
	 * 枚举属性约定：sex--->sexEnumValue	
	 * @param list
	 * @return
	 */
	public static List<Map> fillDynamicList(List<Map> list) {
		for (Map<String, Object> item : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getAllowancesI18nEnum()) {
				if(item.get(i18nEnumAble.getCode()) != null){
					item.put(i18nEnumAble.getCode()+"EnumValue",i18nEnumAble.getMap().get( String.valueOf(item.get(i18nEnumAble.getCode()) )  ));
				}
			}
		}
		return list;
	}
	
}
