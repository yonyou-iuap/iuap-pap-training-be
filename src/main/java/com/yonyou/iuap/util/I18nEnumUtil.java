package com.yonyou.iuap.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yonyou.iuap.allowances.constant.AllowanceType;
import com.yonyou.iuap.allowances.constant.Exdeeds;
import com.yonyou.iuap.allowances.constant.Month;
import com.yonyou.iuap.allowances.constant.PickType;
import com.yonyou.iuap.allowances.constant.Sex;
import com.yonyou.iuap.model.constant.ModelType;
import com.yonyou.iuap.passenger.constant.Grade;
import com.yonyou.iuap.passenger.constant.IsVip;
import com.yonyou.iuap.passenger.constant.PayStatus;
import com.yonyou.iuap.purchaseorder.constant.BpmState;
import com.yonyou.iuap.purchaseorder.constant.OrderType;
import com.yonyou.iuap.tree.constant.IsSon;

import cn.hutool.core.util.ReflectUtil;

public class I18nEnumUtil {
	
	public static List<I18nEnumAble> getAllowancesI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(Sex.Female);
		enumList.add(Exdeeds.NotExceeded);
		enumList.add(Month.January);
		enumList.add(PickType.Transfer);
		enumList.add(AllowanceType.AccommodationSubsidy);
		return enumList;
	}
	
	public static List<I18nEnumAble> getModelI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(ModelType.Test1);
		return enumList;
	}
	
	public static List<I18nEnumAble> getPassengerI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(Sex.Female);
		enumList.add(Grade.Intermediate);
		enumList.add(IsVip.No);
		return enumList;
	}
	
	public static List<I18nEnumAble> getTravelingInformationI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(PayStatus.NotPaid);
		return enumList;
	}
	
	public static List<I18nEnumAble> getPurchaseOrderI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(OrderType.Consignment);
		enumList.add(BpmState.Initial);
		return enumList;
	}
	
	public static List<I18nEnumAble> getTableDemoI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(Sex.Female);
		return enumList;
	}
	
	public static List<I18nEnumAble> getTreeDemoI18nEnum(){
		List<I18nEnumAble> enumList = new ArrayList<>();
		enumList.add(IsSon.Exist);
		return enumList;
	}
	
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public static List i18nEnumEntityKeyToValue(List dataList, List<I18nEnumAble> enumList) {
		List resultList = new ArrayList<>();
		for (Object entity : dataList) {
			for (I18nEnumAble i18nEnumAble : enumList) {
				//Object valueObj = MethodUtils.getter(entity, i18nEnumAble.getCode());
				Object valueObj = ReflectUtil.getFieldValue(entity, i18nEnumAble.getCode());
				if (valueObj != null) {
					if(valueObj instanceof Boolean){//枚举有boolean时
						if(valueObj.toString() == "true"){
							valueObj = "1";
						}else {
							valueObj = "0";
						}
					}
					String value = i18nEnumAble.getMap().get(valueObj.toString());
					//MethodUtils.setter(entity, i18nEnumAble.getCode() + "EnumValue", value, String.class);
					ReflectUtil.setFieldValue(entity, i18nEnumAble.getCode() + "EnumValue", value);
				}
			}
			resultList.add(entity);
		}
		return resultList;
	}

	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public static List i18nEnumMapKeyToValue(List<Map> dataMapList, List<I18nEnumAble> enumList) {
		for (Map<String, Object> item : dataMapList) {
			for (I18nEnumAble i18nEnumAble : enumList) {
				if (item.get(i18nEnumAble.getCode()) != null) {
					item.put(i18nEnumAble.getCode() + "EnumValue",
							i18nEnumAble.getMap().get(String.valueOf(item.get(i18nEnumAble.getCode()))));
				}
			}
		}
		return dataMapList;
	}
}
