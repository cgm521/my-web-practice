/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author cgm
 * @version $Id: oauthUtils.java, v 0.1 2018-03-23 16:08 cgm Exp $$
 */
public class oauthUtils {
    public static final String APP_ID = "wx89f041f0c9e1ffa6";
    public static final String APP_SECRET = "b6e07525c37c63e8e296c5d5ba2062b1";

    public static String doGetJson(String url) throws IOException {
        String result = null;
//        DefaultHttpClient client = new DefaultHttpClient();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            result = EntityUtils.toString(entity);
            System.out.println(result);
//            jsonObject = JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return result;
    }

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "http://localhost:8080/ipos-chains/login?password=e10adc3949ba59abbe56e057f20f883e&username=15801115436";

        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestMethod("POST"); // 设置请求方式
        connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        connection.connect();

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        out.flush();
        out.close();
        int code = connection.getResponseCode();
        InputStream is = null;
        if (code == 200) {
            is = connection.getInputStream();
        } else {
            is = connection.getErrorStream();
        }
        // 读取响应
        int length = (int) connection.getContentLength();// 获取长度
        if (length != -1) {
            byte[] data = new byte[length];
            byte[] temp = new byte[512];
            int readLen = 0;
            int destPos = 0;
            while ((readLen = is.read(temp)) > 0) {
                System.arraycopy(temp, 0, data, destPos, readLen);
                destPos += readLen;
            }
            String result = new String(data, "UTF-8"); // utf-8编码
            System.out.println(result);
        }
        /*
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);
//            jsonObject = JSONObject.fromObject(result);
        httpGet.releaseConnection();*/
    }

}
