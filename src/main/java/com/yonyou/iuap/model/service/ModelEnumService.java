package com.yonyou.iuap.model.service;

import com.yonyou.iuap.model.entity.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

@Service
public class ModelEnumService implements QueryFeatureExtension<Model> {

	private static Map<String, String> modelTypeMap = new HashMap<String, String>();
	static {
		modelTypeMap.put("1", MessageSourceUtil.getMessage("ja.tree.enum.0001","测试1"));
		modelTypeMap.put("2", MessageSourceUtil.getMessage("ja.tree.enum.0002","测试2"));
	}

	@Override
	public List<Model> afterListQuery(List<Model> list) {
		List<Model> resultList = new ArrayList<Model>();
		for (Model entity : list) {
			if (entity.getModelType() != null) {
				String value = modelTypeMap.get(entity.getModelType().toString());
				entity.setModelTypeEnumValue(value);
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
