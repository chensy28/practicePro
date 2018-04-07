package com.csy.reflection;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年02月07日 下午15:17
 *
 * @author csypc
 * @version 1.0
 */
class Demo {

    private String id;

    private String name;

    public String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo(String id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Demo() {
        System.out.println("deom init");
    }

    private Demo(String id){

    }

    private void show(){}


}
