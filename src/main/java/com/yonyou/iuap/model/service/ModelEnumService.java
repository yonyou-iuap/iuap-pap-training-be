package com.yonyou.iuap.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.util.I18nEnumUtil;

@Service
public class ModelEnumService implements QueryFeatureExtension<Model> {
	
	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<Model> afterListQuery(List<Model> list) {		
		return I18nEnumUtil.i18nEnumEntityKeyToValue(list, I18nEnumUtil.getModelI18nEnum());
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
