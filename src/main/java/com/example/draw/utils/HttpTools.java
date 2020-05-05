package com.example.draw.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class HttpTools {
    /**
     * 获取手机的ip
     * //     * @param request
     *
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        // ipAddress = this.getRequest().getRemoteAddr();
        return ipAddress;
    }

    /**
     * post请求方法
     */
    public static String postXml_returnStringXml(String requestUrl,
                                                 String XML) {
        HttpClient httpclient = new HttpClient();// 产生一个http客户端实体类
        PostMethod postMethod = new PostMethod(requestUrl);//设置post请求、要发送请求的目的url
        // 发送请求
        String strResponse = null;// 用来接收返回的数据
        try {
            RequestEntity entity = new StringRequestEntity(
                    XML, "text/xml", "UTF-8");//产生一个请求实体，标记为text/xml
            postMethod.setRequestEntity(entity);// post请求方式设置实体数据
            httpclient.executeMethod(postMethod);//执行post方式，将实体数据发送出去
            strResponse = new String(postMethod.getResponseBody(), "utf-8");//获取请求返回的字符串数据

        } catch (HttpException e) {

        } catch (IOException e) {

        } finally {
            postMethod.releaseConnection();
        }
        return strResponse;// 返回xml字符串数据
    }
}