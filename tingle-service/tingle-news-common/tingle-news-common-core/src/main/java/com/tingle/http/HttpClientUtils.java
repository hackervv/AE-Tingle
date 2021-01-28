package com.tingle.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/19:41
 * @Description:
 */
public class HttpClientUtils {
    /**
     * Logging
     */
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    
    
    public static RequestConfig getRequestConfig() {
        RequestConfig requestConfig = RequestConfig.custom()
                                              .setConnectTimeout(5000)
                                              .setSocketTimeout(5000)
                                              .setConnectionRequestTimeout(5000)
                                              .build();
        return requestConfig;
    }
    
    
    /**
     * The post request transfers the JSON parameter
     *
     * @param url url
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        // The post request returns the result
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // Set request and transfer timeout
        httpPost.setConfig(getRequestConfig());
        try {
            if (null != jsonParam) {
                // Solve the problem of Chinese garbled code
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // The request was sent successfully and received a response
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // Read the JSON string data returned by the server
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // Convert JSON string to JSON object
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }
    
    /**
     * Post request transfer string parameter. for example：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     *
     * @param url      url
     * @param strParam string param
     * @return
     */
    public static JSONObject httpPost(String url, String strParam) {
        // Post request returns result
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig());
        try {
            if (null != strParam) {
                // Solve the problem of Chinese garbled code
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // The request was sent successfully and received a response
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // Read the JSON string data returned by the server
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // Convert JSON string to JSON object
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }
    
    /**
     * send get request
     *
     * @param url
     * @return
     */
    public static JSONObject httpGet(String url) {
        // Get request returns result
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // Send get request
        HttpGet request = new HttpGet(url);
        request.setConfig(getRequestConfig());
        try {
            CloseableHttpResponse response = client.execute(request);
            
            // The request was sent successfully and received a response
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // Read the JSON string data returned by the server
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // Convert JSON string to JSON object
                jsonResult = JSONObject.parseObject(strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            request.releaseConnection();
        }
        return jsonResult;
    }
    
}
