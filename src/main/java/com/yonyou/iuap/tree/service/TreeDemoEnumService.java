package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TreeDemo;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class TreeDemoEnumService implements QueryFeatureExtension<TreeDemo> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TreeDemo> afterListQuery(List<TreeDemo> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TreeDemo.class);
	}
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
