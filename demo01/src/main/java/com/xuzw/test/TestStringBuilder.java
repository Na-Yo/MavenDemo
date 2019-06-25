package com.xuzw.test;

import java.util.HashMap;
import java.util.Map;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder departIds=new StringBuilder();
        StringBuilder departNames=new StringBuilder();
        Map<String, String> manageDepartMap = new HashMap<>();
        manageDepartMap.put("1","bumen");
        if(manageDepartMap.size()>0){
            for(String key : manageDepartMap.keySet()){
                String value = manageDepartMap.get(key);
                departIds.append(key).append(",");
                departNames.append(value).append(",");
            }
            String manageDepartId=departIds.toString();
            manageDepartId=manageDepartId.substring(0,manageDepartId.length()-1);
            String manageDepartName=departNames.toString();
            manageDepartName=manageDepartName.substring(0,manageDepartName.length()-1);
            System.out.println("manageDepartId:"+manageDepartId);
            System.out.println("manageDepartName:"+manageDepartName);
        }
    }
}
