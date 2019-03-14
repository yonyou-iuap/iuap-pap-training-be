package com.yonyou.iuap.allowances.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.i18n.MessageSourceUtil;

@Service
public class AllowancesEnumServiceCopy implements QueryFeatureExtension<Allowances> {
	private  Map<String, String> sexMap = new HashMap<String, String>();
	private  Map<String, String> exdeedsMap = new HashMap<String, String>();
	private  Map<String, String> allowanceTypeMap = new HashMap<String, String>();
	private  Map<String, String> monthMap = new HashMap<String, String>();
	private  Map<String, String> pickTypeMap = new HashMap<String, String>();

	 {
		sexMap.put("0", MessageSourceUtil.getMessage("ja.all.enum.0001", "女"));
		sexMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0002", "男"));
		exdeedsMap.put("0", MessageSourceUtil.getMessage("ja.all.enum.0003", "未超标"));
		exdeedsMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0004", "超标"));
		allowanceTypeMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0005", "电脑补助"));
		allowanceTypeMap.put("2", MessageSourceUtil.getMessage("ja.all.enum.0006", "住宿补助"));
		allowanceTypeMap.put("3", MessageSourceUtil.getMessage("ja.all.enum.0007", "交通补助"));
		monthMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0008", "一月"));
		monthMap.put("2", MessageSourceUtil.getMessage("ja.all.enum.0009", "二月"));
		monthMap.put("3", MessageSourceUtil.getMessage("ja.all.enum.0010", "三月"));
		monthMap.put("4", MessageSourceUtil.getMessage("ja.all.enum.0011", "四月"));
		monthMap.put("5", MessageSourceUtil.getMessage("ja.all.enum.0012", "五月"));
		monthMap.put("6", MessageSourceUtil.getMessage("ja.all.enum.0013", "六月"));
		monthMap.put("7", MessageSourceUtil.getMessage("ja.all.enum.0014", "七月"));
		monthMap.put("8", MessageSourceUtil.getMessage("ja.all.enum.0015", "八月"));
		monthMap.put("9", MessageSourceUtil.getMessage("ja.all.enum.0016", "九月"));
		monthMap.put("10", MessageSourceUtil.getMessage("ja.all.enum.0017", "十月"));
		monthMap.put("11", MessageSourceUtil.getMessage("ja.all.enum.0018", "十一月"));
		monthMap.put("12", MessageSourceUtil.getMessage("ja.all.enum.0019", "十二月"));
		pickTypeMap.put("1", MessageSourceUtil.getMessage("ja.all.enum.0020", "转账"));
		pickTypeMap.put("2", MessageSourceUtil.getMessage("ja.all.enum.0021", "现金"));
	}

	public static List<Map> fillDynamicList(List<Map> list) {
		AllowancesEnumServiceCopy ae = new AllowancesEnumServiceCopy();
		for (Map<String, Object> item : list) {
			if(item.get("sex") != null){
				item.put("sexEnumValue",ae.sexMap.get( String.valueOf(item.get("sex") )  ));
			}
			if(item.get("exdeeds") != null){
				item.put("exdeedsEnumValue",ae.exdeedsMap.get( String.valueOf(item.get("exdeeds") )  ));
			}
			if(item.get("allowanceType") != null){
				item.put("allowanceTypeEnumValue",ae.allowanceTypeMap.get( String.valueOf(item.get("allowanceType") )  ));
			}
			if(item.get("month") != null){
				item.put("monthEnumValue",ae.monthMap.get( String.valueOf(item.get("month") )  ));
			}
			if(item.get("pickType") != null){
				item.put("pickTypeEnumValue",ae.pickTypeMap.get( String.valueOf(item.get("pickType") )  ));
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
	
	public static void main(String[] args) {
		String str= "";
		System.out.println(str.toString());
		
	}
	
}
