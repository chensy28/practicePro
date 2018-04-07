package com.csy.createthread.proxy;

/**
 * 项目名称：springbasic
 * 类名称：静态代理
 * 类描述：
 * 创建时间：2016年03月06日 下午21:46
 *
 * @author csypc
 * @version 1.0
 */
public class StaticProxy {
    //静态代理 设计模式
    //真实角色
    //代理角色 ：持有真色角色的引用
    //二者实现相同的接口

    public static void main(String[] args) {
        You you = new You();
        MarryCompany marryCompany = new MarryCompany(you);
        marryCompany.marry();
    }

}

//真实角色
class You implements Marry{
    @Override
    public void marry(){
        System.out.println("xiaoli marry with a girl！");
    }
}

//代理角色
class MarryCompany implements Marry{

    private You you;
    public MarryCompany(){

    }

    //持有真实角色的引用
    public MarryCompany(You you){
       this.you = you;
    }
    public void before(){
        System.out.println("marry before !");
    }

    public void after(){
        System.out.println("marry after !");
    }

    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }
}

//公共接口
interface Marry{
    void marry();
}
