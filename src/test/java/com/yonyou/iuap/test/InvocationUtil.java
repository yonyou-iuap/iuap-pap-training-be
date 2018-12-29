package com.yonyou.iuap.test;

import java.util.HashMap;
import java.util.Map;
import com.yonyou.iuap.context.InvocationInfoProxy;

public class InvocationUtil {

    public void setInvocation(){
        String cookies = "_TH_=primary; _A_P_userId=U001; _A_P_userType=2; _A_P_userLoginName=admin; _A_P_userName=%25E7%25B3%25BB%25E7%25BB%259F%25E7%25AE%25A1%25E7%2590%2586%25E5%2591%2598; _A_P_userAvator=http%253A%252F%252F172.20.17.90%253A8080%252Fwbalone%252Fimages%252Ff5ba1b14-523b-4e7a-85e4-0baa286ed1b3_.gif; u_locale=zh_CN; locale_serial=1; u_usercode=U001; tenantid=tenant; userType=userType; typeAlias=typeAlias; userId=U001; i18next=zh_CN; sessionid=d372bde4-a403-46a3-adce-6c97d312095b; token=d2ViLDM2MDAsV1JDaVVXQTdKb3JaSURZTEtzVTY5d09Ca0JZN1JzZDkwaXYyenBKNmFNcmxlOVZuMlVGWERWNHR3cjBuWmFTREN5R2Nma2xGdWpzOW5xWXNBNUtpVVE9PQ; u_logints=1543471123752";
        String[] cookie = cookies.split(";");
        Map map = new HashMap();
        for (int i = 0; i < cookie.length; i++) {
            String cookieItem = cookie[i];
            String[] item = cookieItem.split("=");
            InvocationInfoProxy.setParameter(item[0].trim(),item[1].trim());
        }
    }

}
