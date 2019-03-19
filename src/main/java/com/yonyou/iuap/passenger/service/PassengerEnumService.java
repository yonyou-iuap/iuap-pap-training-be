package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.passenger.entity.Passenger;

import java.util.List;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.enumeration.utils.EnumValueUtils;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class PassengerEnumService implements QueryFeatureExtension<Passenger> {

	@SuppressWarnings(value = { "unchecked"})
	@Override
	public List<Passenger> afterListQuery(List<Passenger> list) {
		return EnumValueUtils.i18nEnumEntityKeyToValue(list, Passenger.class);
	}
	
	@SuppressWarnings(value = { "rawtypes"})
	@Override
	public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
		return searchParams;
	}
}
