package com.yonyou.iuap.allowances.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;


@Service
public class AllowancesEnumService implements QueryFeatureExtension<Allowances> {

	
	@SuppressWarnings(value = { "unchecked" })
	@Override
	public List<Allowances> afterListQuery(List<Allowances> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, Allowances.class);
	}

	@SuppressWarnings(value = { "rawtypes" })
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}

	/**
	 * 动态查询数据 枚举值key-to-value 枚举属性约定：sex--->sexEnumValue
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public static List<Map> fillDynamicList(List<Map> list) {
		return EnumValueUtils.i18nEnumMapKeyToValue(list, Allowances.class);
	}
}
