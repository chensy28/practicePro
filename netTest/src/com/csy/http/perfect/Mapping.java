package com.csy.http.perfect;

import java.util.List;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������ӳ����
 * ����ʱ�䣺2016��04��14�� ����08:03
 *
 * @author csypc
 * @version 1.0
 */
public class Mapping {
    private String name;

    private List<String> urlList;

    public Mapping(){}

    public Mapping(String name, List<String> urlList) {
        this.name = name;
        this.urlList = urlList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }


}
