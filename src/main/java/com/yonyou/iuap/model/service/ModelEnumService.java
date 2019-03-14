package com.yonyou.iuap.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.i18n.MethodUtils;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

@Service
public class ModelEnumService implements QueryFeatureExtension<Model> {
	
	@Override
	public List<Model> afterListQuery(List<Model> list) {
		List<Model> resultList = new ArrayList<Model>();
		for (Model entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getModelI18nEnum()) {
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
}
