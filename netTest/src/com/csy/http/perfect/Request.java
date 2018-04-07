package com.csy.http.perfect;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.StringTokenizer;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������װ�ͻ�����Ϣ
 * ����ʱ�䣺2016��04��08�� ����12:52
 *
 * @author csypc
 * @version 1.0
 */
public class Request {

    //�н�������س���
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//����

    //����ʽ
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

    //Э��
    private String protocol;
    //����
    private Map<String,List<String>> map;
    //����ͷ��Ϣ
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

    //�����ַ���(����Ӵ�ʱ��Ҫȥ���ո�)
    public void parse(){
        byte []info = new byte[20480];
        try {
            //����������ȡ����
            int len = inputStream.read(info);

            String requestStr = new String(info,0,len);
            System.out.println("��ȡ�����ַ�����"+requestStr);

            String paramterStr = "";//�����ַ���
            //System.out.println("toString������"+info.toString());
            //int index = info.toString().indexOf(CRLF); //���õ������toString(),���Բ����ǽ��ֽ�����ת��ΪString
            int index = requestStr.indexOf(CRLF);
            String firstStr = new String(info,0,index);

            int urlIndex = firstStr.indexOf("/");
            method = firstStr.substring(0,urlIndex).trim();

            int httpIndex = firstStr.indexOf("HTTP");
            url = firstStr.substring(urlIndex,httpIndex).trim();

            protocol = firstStr.substring(httpIndex);

            if(method.equalsIgnoreCase("get")){
                if(url.contains("?")) { //�ж��Ƿ���ڲ���
                    String[] arr = url.split("\\?");
                    url = arr[0].trim();
                    paramterStr = arr[1].trim();
                }
            }else{ //post��ʽ�Ĳ�����������
                paramterStr = requestStr.substring(requestStr.lastIndexOf(CRLF)).trim();
            }

            //��װ����
            parseParams(paramterStr);
            System.out.println("�ͻ���������Ϣ"+"method:"+method+",url:"+url+",protocol:"+protocol+",paramterStr:"+paramterStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //��������װ��map��
    public void parseParams(String paramterStr){

        StringTokenizer tokenizer = new StringTokenizer(paramterStr,"&");
        while (tokenizer.hasMoreTokens()){
            String str = tokenizer.nextToken();
            //���Ⱥŷָ�
            String []arr = str.split("=");
            String key = "";
            String value = "";
            if(arr.length == 1){ //=����ֻ��һ������
                key = arr[0];
                value = null;
            }else{              //=��������������
                key = arr[0];
                value = arr[1];
            }
            List<String> list = new ArrayList<String>();
            list.add(value);

            //�ж��Ƿ�����ظ��ļ�(ʹ��map�����ظ�)
            if(!map.containsKey(key)){
                map.put(key,list);
            }else{//����������ֵ�����е��б���
                List<String> oldList = map.get(key);
                oldList.addAll(list);
                map.put(key,oldList);
            }

        }
    }

    //��ȡ������Ӧ��ֵ
    public String getValue(String key){
        List<String> list = map.get(key);
        if(null == list) {
            return null;
        }else{
            return list.get(0);
        }
    }

    //��ȡ������Ӧ��ֵ(���)
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
