package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TreeDemo;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.i18n.MethodUtils;

@Service
public class TreeDemoEnumService implements QueryFeatureExtension<TreeDemo> {

	@Override
	public List<TreeDemo> afterListQuery(List<TreeDemo> list) {
		List<TreeDemo> resultList = new ArrayList<TreeDemo>();
		for (TreeDemo entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getTreeDemoI18nEnum()) {
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
