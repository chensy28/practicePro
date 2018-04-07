package com.csy.http.perfect;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 项目名称：
 * 类名称：
 * 类描述：封装客户端信息
 * 创建时间：2016年04月08日 下午12:52
 *
 * @author csypc
 * @version 1.0
 */
public class Request {

    //行结束符与回车符
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//空行

    //请求方式
    private String method;
    //url
    private String url;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<String>> map) {
        this.map = map;
    }

    public StringBuilder getTitleInfo() {
        return titleInfo;
    }

    public void setTitleInfo(StringBuilder titleInfo) {
        this.titleInfo = titleInfo;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    //协议
    private String protocol;
    //参数
    private Map<String,List<String>> map;
    //请求头信息
    private StringBuilder titleInfo;

    private InputStream inputStream;

    public Request(){
        method = "";
        url = "";
        protocol = "";
        map = new HashMap<>();
        titleInfo = new StringBuilder();
    }

    public Request(InputStream inputStream){
        this();
        this.inputStream = inputStream;
    }

    //解析字符串(求解子串时需要去掉空格)
    public void parse(){
        byte []info = new byte[20480];
        try {
            //从输入流读取数据
            int len = inputStream.read(info);

            String requestStr = new String(info,0,len);
            System.out.println("获取到的字符串："+requestStr);

            String paramterStr = "";//参数字符串
            //System.out.println("toString方法："+info.toString());
            //int index = info.toString().indexOf(CRLF); //调用到对象的toString(),所以并不是将字节数据转化为String
            int index = requestStr.indexOf(CRLF);
            String firstStr = new String(info,0,index);

            int urlIndex = firstStr.indexOf("/");
            method = firstStr.substring(0,urlIndex).trim();

            int httpIndex = firstStr.indexOf("HTTP");
            url = firstStr.substring(urlIndex,httpIndex).trim();

            protocol = firstStr.substring(httpIndex);

            if(method.equalsIgnoreCase("get")){
                if(url.contains("?")) { //判断是否存在参数
                    String[] arr = url.split("\\?");
                    url = arr[0].trim();
                    paramterStr = arr[1].trim();
                }
            }else{ //post方式的参数在正文中
                paramterStr = requestStr.substring(requestStr.lastIndexOf(CRLF)).trim();
            }

            //封装参数
            parseParams(paramterStr);
            System.out.println("客户端请求信息"+"method:"+method+",url:"+url+",protocol:"+protocol+",paramterStr:"+paramterStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //将参数封装到map中
    public void parseParams(String paramterStr){

        StringTokenizer tokenizer = new StringTokenizer(paramterStr,"&");
        while (tokenizer.hasMoreTokens()){
            String str = tokenizer.nextToken();
            //按等号分割
            String []arr = str.split("=");
            String key = "";
            String value = "";
            if(arr.length == 1){ //=两边只有一个参数
                key = arr[0];
                value = null;
            }else{              //=两边有两个参数
                key = arr[0];
                value = arr[1];
            }
            List<String> list = new ArrayList<String>();
            list.add(value);

            //判断是否包含重复的键(使得map键不重复)
            if(!map.containsKey(key)){
                map.put(key,list);
            }else{//若包含，把值添到已有的列表中
                List<String> oldList = map.get(key);
                oldList.addAll(list);
                map.put(key,oldList);
            }

        }
    }

    //获取参数对应的值
    public String getValue(String key){
        List<String> list = map.get(key);
        if(null == list) {
            return null;
        }else{
            return list.get(0);
        }
    }

    //获取参数对应的值(多个)
    public String[] getValues(String key){
        List<String> list = null;
        if(null == map.get(key)){
            return null;
        }else{
            list = map.get(key);
            return list.toArray(new String[0]);
        }

    }

    public static void main(String[] args) {
        Request request = new Request();
        request.parseParams("aa=1&cc=e&dd=&aa=5");
        System.out.println(request.getValue("cc"));
        System.out.println(request.getValues("aa"));
    }

}
