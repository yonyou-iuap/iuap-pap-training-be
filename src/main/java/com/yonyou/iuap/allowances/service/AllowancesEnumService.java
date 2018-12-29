package com.yonyou.iuap.allowances.service;

import com.yonyou.iuap.allowances.entity.Allowances;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class AllowancesEnumService implements QueryFeatureExtension<Allowances> {
	private static Map<String, String> sexMap = new HashMap<String, String>();
	private static Map<String, String> exdeedsMap = new HashMap<String, String>();
	private static Map<String, String> allowanceTypeMap = new HashMap<String, String>();
	private static Map<String, String> monthMap = new HashMap<String, String>();
	private static Map<String, String> pickTypeMap = new HashMap<String, String>();
	static {
		sexMap.put("0", "女");
		sexMap.put("1", "男");
		exdeedsMap.put("0", "未超标");
		exdeedsMap.put("1", "超标");
		allowanceTypeMap.put("1", "电脑补助");
		allowanceTypeMap.put("2", "住宿补助");
		allowanceTypeMap.put("3", "交通补助");
		monthMap.put("1", "一月");
		monthMap.put("2", "二月");
		monthMap.put("3", "三月");
		monthMap.put("4", "四月");
		monthMap.put("5", "五月");
		monthMap.put("6", "六月");
		monthMap.put("7", "七月");
		monthMap.put("8", "八月");
		monthMap.put("9", "九月");
		monthMap.put("10", "十月");
		monthMap.put("11", "十一月");
		monthMap.put("12", "十二月");
		pickTypeMap.put("1", "转账");
		pickTypeMap.put("2", "现金");
	}

	public static List<Map> fillDynamicList(List<Map> list) {
		for (Map<String, Object> item : list) {
			if(item.get("sex") != null){
				item.put("sexEnumValue",sexMap.get( String.valueOf(item.get("sex") )  ));
			}
			if(item.get("exdeeds") != null){
				item.put("exdeedsEnumValue",exdeedsMap.get( String.valueOf(item.get("exdeeds") )  ));
			}
			if(item.get("allowanceType") != null){
				item.put("allowanceTypeEnumValue",allowanceTypeMap.get( String.valueOf(item.get("allowanceType") )  ));
			}
			if(item.get("month") != null){
				item.put("monthEnumValue",monthMap.get( String.valueOf(item.get("month") )  ));
			}
			if(item.get("pickType") != null){
				item.put("pickTypeEnumValue",pickTypeMap.get( String.valueOf(item.get("pickType") )  ));
			}
		}
		return list;
	}
	
	@Override
	public List<Allowances> afterListQuery(List<Allowances> list) {
		List<Allowances> resultList = new ArrayList<Allowances>();
		for (Allowances entity : list) {
			if (entity.getSex() != null) {
				String value = sexMap.get(entity.getSex().toString());
				entity.setSexEnumValue(value);
			}
			if (entity.getExdeeds() != null) {
				String value = exdeedsMap.get(entity.getExdeeds().toString());
				entity.setExdeedsEnumValue(value);
			}
			if (entity.getAllowanceType() != null) {
				String value = allowanceTypeMap.get(entity.getAllowanceType().toString());
				entity.setAllowanceTypeEnumValue(value);
			}
			if (entity.getMonth() != null) {
				String value = monthMap.get(entity.getMonth().toString());
				entity.setMonthEnumValue(value);
			}
			if (entity.getPickType() != null) {
				String value = pickTypeMap.get(entity.getPickType().toString());
				entity.setPickTypeEnumValue(value);
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
