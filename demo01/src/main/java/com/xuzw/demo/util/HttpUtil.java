package com.xuzw.demo.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static String post(String url, Map<String, Object> param) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建一个post对象
            HttpPost post = new HttpPost(url);
            //创建一个Entity。模拟一个表单
            List<NameValuePair> kvList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> enty : param.entrySet()) {
                kvList.add(new BasicNameValuePair(enty.getKey(), String.valueOf(enty.getValue())));
            }
            //包装成一个Entity对象
            StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
            //设置请求的内容
            post.setEntity(entity);
            //执行post请求
            CloseableHttpResponse response = httpClient.execute(post);
            if(response.getStatusLine().getStatusCode()!=200){
                throw new RuntimeException("返回状态异常：" + response.getStatusLine().getStatusCode());
            }
            String string = EntityUtils.toString(response.getEntity());
            response.close();
            httpClient.close();
            return string;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String get(String url, Map<String, Object> param) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建一个post对象
            HttpGet post = new HttpGet(url);
            //创建一个Entity。模拟一个表单
//            List<NameValuePair> kvList = new ArrayList<>();
//            for (Map.Entry<String, Object> enty : param.entrySet()) {
//                kvList.add(new BasicNameValuePair(enty.getKey(), String.valueOf(enty.getValue())));
//            }
            //包装成一个Entity对象
//            StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
            //设置请求的内容
//            post.setEntity(entity);
            //执行post请求
            CloseableHttpResponse response = httpClient.execute(post);
            if(response.getStatusLine().getStatusCode()!=200){
                throw new RuntimeException("返回状态异常：" + response.getStatusLine().getStatusCode());
            }
            String string = EntityUtils.toString(response.getEntity());
            response.close();
            httpClient.close();
            return string;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
