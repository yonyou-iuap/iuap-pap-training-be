package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TableDemo;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class TableDemoEnumService implements QueryFeatureExtension<TableDemo> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TableDemo> afterListQuery(List<TableDemo> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TableDemo.class);
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
