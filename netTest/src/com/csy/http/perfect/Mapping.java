package com.csy.http.perfect;

import java.util.List;

/**
 * 项目名称：
 * 类名称：
 * 类描述：映射类
 * 创建时间：2016年04月14日 下午08:03
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
