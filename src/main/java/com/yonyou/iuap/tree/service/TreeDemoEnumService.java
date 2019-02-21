package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TreeDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

@Service
public class TreeDemoEnumService implements QueryFeatureExtension<TreeDemo> {

	private static Map<String, String> isSonMap = new HashMap<String, String>();
	static {
		isSonMap.put("1", MessageSourceUtil.getMessage("ja.tree.enum.0001","没有"));
		isSonMap.put("2", MessageSourceUtil.getMessage("ja.tree.enum.0002","有"));
	}

	@Override
	public List<TreeDemo> afterListQuery(List<TreeDemo> list) {
		List<TreeDemo> resultList = new ArrayList<TreeDemo>();
		for (TreeDemo entity : list) {
			if (entity.getIsSon() != null) {
				String value = isSonMap.get(entity.getIsSon().toString());
				entity.setIsSonEnumValue(value);
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
