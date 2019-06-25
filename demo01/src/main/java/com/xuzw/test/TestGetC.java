package com.xuzw.test;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TestGetC {

    public static void main(String[] args) {
        String[] oldArray ={"1", "2", "3"};
        String[] newArray ={"1", "4","6"};

        String[] insertIdArray = getC(newArray, oldArray);
        String[] deleteIdArray = getC(oldArray, newArray);

        Arrays.stream(insertIdArray).forEach(System.out::println);
        System.out.println("============");
        Arrays.stream(deleteIdArray).forEach(System.out::println);

        String departId = "1,2,3,4,5";
        String departName = "B1,B2,B3,B4,B5";
        String[] departIdArray = departId.split(",");
        LinkedList<String> departIdLinkList = new LinkedList<>(Arrays.asList(departIdArray));//后面要删除，这个效率高
        String[] departNameArray = departName.split(",");
        LinkedList<String> departNameLinkList = new LinkedList<>(Arrays.asList(departNameArray));//后面要删除，这个效率高
        if(StringUtils.isNotEmpty(departId) && StringUtils.isNotEmpty(departName)){
            /*LinkedList<String> departIdLinkList = new LinkedList<>(Arrays.asList(departIdArray));//后面要删除，这个效率高
            String[] departNameArray = departName.split(",");
            LinkedList<String> departNameLinkList = new LinkedList<>(Arrays.asList(departNameArray));//后面要删除，这个效率高*/
            for (Iterator<String> it=departIdLinkList.iterator();it.hasNext();) {
                //是否存在删除的需求管理部门中，如果存在，则删除
                String next = it.next();
                boolean isContains = ArrayUtils.contains(deleteIdArray, next);
                if(isContains){
                    int i = departIdLinkList.indexOf(next);
                    it.remove();
                    departNameLinkList.remove(i);//删除部门名称
                }
            }
            String[] newDepartIdArray = departIdLinkList.toArray(new String[departIdLinkList.size()]);
            String[] newDepartNameArray = departNameLinkList.toArray(new String[departNameLinkList.size()]);
            String newDepartIds = StringUtils.join(newDepartIdArray, ",");
            String newDepartNames = StringUtils.join(newDepartNameArray, ",");
            System.out.println(newDepartIds);
            System.out.println(newDepartNames);
        }

        if(ArrayUtils.isNotEmpty(insertIdArray)){
            //构造集合 key(部门id) value(部门名称)
            Map<String, String> manageDepartMap = new HashMap<>();
            String newManageDepartName = "B1,B4,B6";//部门名称
            newManageDepartName = StringUtils.isEmpty(newManageDepartName) ? "" : newManageDepartName;
            String[] newManageDepartNameArray = newManageDepartName.split(",");
            for (int i = 0; i < newArray.length; i++) {
                manageDepartMap.put(newArray[i],newManageDepartNameArray[i]);
            }
            /*String[] departIdArray = departId.split(",");
            LinkedList<String> departIdLinkList = new LinkedList<>(Arrays.asList(departIdArray));//后面要添加，这个效率高
            String[] departNameArray = departName.split(",");
            LinkedList<String> departNameLinkList = new LinkedList<>(Arrays.asList(departNameArray));//后面要添加，这个效率高*/
            Arrays.stream(insertIdArray).forEach(e ->{
                boolean contains = departIdLinkList.contains(e);
                if(!contains){
                    departIdLinkList.add(e);
                    departNameLinkList.add(manageDepartMap.get(e));
                }
            });
            String[] newDepartIdArray = departIdLinkList.toArray(new String[departIdLinkList.size()]);
            String[] newDepartNameArray = departNameLinkList.toArray(new String[departNameLinkList.size()]);
            String newDepartIds = StringUtils.join(newDepartIdArray, ",");
            String newDepartNames = StringUtils.join(newDepartNameArray, ",");
            System.out.println(newDepartIds);
            System.out.println(newDepartNames);
        }


    }


    /**
     * 求差集
     *
     * @param m 大的
     * @param n 小的
     * @return
     */
    private static String[] getC(String[] m, String[] n) {
        // 将较长的数组转换为set
        Set<String> set = new HashSet<String>(Arrays.asList(m));

        // 遍历较短的数组，实现最少循环
        for (String i : n) {
            // 如果集合里有相同的就删掉
            if (set.contains(i)) {
                set.remove(i);
            }
        }
        String[] arr = {};
        return set.toArray(arr);
    }
}
