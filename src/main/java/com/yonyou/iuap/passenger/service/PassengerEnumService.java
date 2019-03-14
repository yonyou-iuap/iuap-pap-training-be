package com.yonyou.iuap.passenger.service;

import com.yonyou.iuap.passenger.entity.Passenger;
import com.yonyou.iuap.util.I18nEnumAble;
import com.yonyou.iuap.util.I18nEnumUtil;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MethodUtils;

@Service
public class PassengerEnumService implements QueryFeatureExtension<Passenger> {

	@Override
	public List<Passenger> afterListQuery(List<Passenger> list) {
		List<Passenger> resultList = new ArrayList<Passenger>();
		for (Passenger entity : list) {
			for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getPassengerI18nEnum()) {
				Object valueObj = MethodUtils.getter(entity,i18nEnumAble.getCode());
				if(valueObj != null){
					if(valueObj instanceof Boolean){//枚举有boolean时
						if(valueObj.toString() == "true"){
							valueObj = "1";
						}else {
							valueObj = "0";
						}
					}
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

	public static void main(String[] args) {
		boolean flag = false;
		System.out.println(String.valueOf(flag));
		
		for (I18nEnumAble i18nEnumAble : I18nEnumUtil.getPassengerI18nEnum()) {
			Object getter = false;
			if(getter != null){
				if(getter instanceof Boolean){
					if(getter.toString() == "true"){
						getter ="0";
						System.out.println(11111111);
					}else {
						getter = "1";
						System.out.println(2222222);
					}
				}else {
					System.out.println(33333);
				}
				System.out.println(i18nEnumAble.getMap().get(getter));
			}
		}
	}
}
