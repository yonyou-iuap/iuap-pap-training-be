package com.yonyou.iuap.passenger.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import com.yonyou.iuap.util.I18nEnumUtil;

@Service
public class TravelingInformationEnumService implements QueryFeatureExtension<TravelingInformation> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<TravelingInformation> afterListQuery(List<TravelingInformation> list) {		
		return I18nEnumUtil.i18nEnumEntityKeyToValue(list, I18nEnumUtil.getTravelingInformationI18nEnum());
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
