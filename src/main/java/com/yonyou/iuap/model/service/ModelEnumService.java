package com.yonyou.iuap.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class ModelEnumService implements QueryFeatureExtension<Model> {
	
	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<Model> afterListQuery(List<Model> list) {		
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, Model.class);
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
