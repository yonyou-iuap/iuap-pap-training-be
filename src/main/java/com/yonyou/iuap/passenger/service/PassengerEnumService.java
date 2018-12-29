package com.yonyou.iuap.passenger.service;
import com.yonyou.iuap.passenger.entity.Passenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

@Service
public class PassengerEnumService implements QueryFeatureExtension<Passenger>{
    
	private static Map<String, String> sexMap = new HashMap<String, String>();
	private static Map<String, String> gradeMap = new HashMap<String, String>();
	private static Map<String, String> isVipMap = new HashMap<String, String>();
        static{         
                sexMap.put("1", "女");
                sexMap.put("2", "男");
                //gradeMap.put("0", "非会员");
                gradeMap.put("1", "初级会员");
                gradeMap.put("2", "中级会员");
                gradeMap.put("3", "高级会员");
                isVipMap.put("0", "否");
                isVipMap.put("1", "是");
        }
    
        
        @Override
        public List<Passenger> afterListQuery(List<Passenger> list) {
                List<Passenger> resultList = new ArrayList<Passenger>();      
        for (Passenger entity : list) {
                        if(entity.getSex() != null){
                                String value = sexMap.get(entity.getSex().toString());
                                entity.setSexEnumValue(value);
                        }
                        if(entity.getGrade() != null){
                                String value = gradeMap.get(entity.getGrade().toString());
                                entity.setGradeEnumValue(value);
                        }
                        if(entity.getIsVip()){
                                String value = isVipMap.get("1");
                                entity.setIsVipEnumValue(value);
                        }else {
                        	 String value = isVipMap.get("0");
                        	 entity.setIsVipEnumValue(value);
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
			boolean  flag = false;
			System.out.println(String.valueOf(flag));
		}
}

