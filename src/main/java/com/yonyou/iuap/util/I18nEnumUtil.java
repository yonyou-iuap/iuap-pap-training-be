package com.yonyou.iuap.util;

import java.util.ArrayList;
import java.util.List;

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
	
}
