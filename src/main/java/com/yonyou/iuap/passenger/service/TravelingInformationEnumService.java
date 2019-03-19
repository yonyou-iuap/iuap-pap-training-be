package com.yonyou.iuap.passenger.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.passenger.entity.TravelingInformation;

@Service
public class TravelingInformationEnumService implements QueryFeatureExtension<TravelingInformation> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TravelingInformation> afterListQuery(List<TravelingInformation> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, TravelingInformation.class);
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
