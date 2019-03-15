package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TableDemo;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class TableDemoEnumService implements QueryFeatureExtension<TableDemo> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TableDemo> afterListQuery(List<TableDemo> list) {
		return I18nEnumUtil.i18nEnumEntityKeyToValue(list, I18nEnumUtil.getTableDemoI18nEnum());
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
