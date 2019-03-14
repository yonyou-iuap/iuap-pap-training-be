package com.yonyou.iuap.passenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.i18n.MethodUtils;
import com.yonyou.iuap.passenger.entity.TravelingInformation;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

@Service
public class TravelingInformationEnumService implements QueryFeatureExtension<TravelingInformation> {

	@Override
	public List<TravelingInformation> afterListQuery(List<TravelingInformation> list) {
		List<TravelingInformation> resultList = new ArrayList<TravelingInformation>();
		for (TravelingInformation entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getTravelingInformationI18nEnum()) {
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
