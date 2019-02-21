package com.yonyou.iuap.tree.service;

import com.yonyou.iuap.tree.entity.TableDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

@Service
public class TableDemoEnumService implements QueryFeatureExtension<TableDemo> {

	private static Map<String, String> sexMap = new HashMap<String, String>();
	static {
		sexMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0001", "女"));
		sexMap.put("2", MessageSourceUtil.getMessage("ja.all.enum.0002", "男"));
	}

	@Override
	public List<TableDemo> afterListQuery(List<TableDemo> list) {
		List<TableDemo> resultList = new ArrayList<TableDemo>();
		for (TableDemo entity : list) {
			if (entity.getSex() != null) {
				String value = sexMap.get(entity.getSex().toString());
				entity.setSexEnumValue(value);
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
