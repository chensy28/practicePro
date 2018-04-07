package com.csy.http.perfect;

/**
 * 项目名称：
 * 类名称：
 * 类描述：servlet类定义
 * 创建时间：2016年04月14日 下午08:00
 *
 * @author csypc
 * @version 1.0
 */
public class Entity {
    private String name;
    private String clz;

    public Entity(){

    }
    public Entity(String name, String clz) {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
