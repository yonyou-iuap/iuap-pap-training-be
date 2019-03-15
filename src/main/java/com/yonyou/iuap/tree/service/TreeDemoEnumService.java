package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TreeDemo;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class TreeDemoEnumService implements QueryFeatureExtension<TreeDemo> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TreeDemo> afterListQuery(List<TreeDemo> list) {		
		return I18nEnumUtil.i18nEnumEntityKeyToValue(list, I18nEnumUtil.getTreeDemoI18nEnum());
	}
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
