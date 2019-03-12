package com.yonyou.iuap.passenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;
import com.yonyou.iuap.passenger.entity.TravelingInformation;

@Service
public class TravelingInformationEnumService implements QueryFeatureExtension<TravelingInformation> {

	private static Map<String, String> payStatusMap = new HashMap<String, String>();
	static {
		payStatusMap.put("1", MessageSourceUtil.getMessage("ja.pas.enum.0006", "未支付"));
		payStatusMap.put("2", MessageSourceUtil.getMessage("ja.pas.enum.0007", "已支付"));
	}

	@Override
	public List<TravelingInformation> afterListQuery(List<TravelingInformation> list) {
		List<TravelingInformation> resultList = new ArrayList<TravelingInformation>();
		for (TravelingInformation entity : list) {
			if (entity.getPayStatus() != null) {
				String value = payStatusMap.get(entity.getPayStatus().toString());
				entity.setPayStatusEnumValue(value);
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
