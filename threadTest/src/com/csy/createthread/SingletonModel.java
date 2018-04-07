package com.csy.createthread;

/**
 * 项目名称：
 * 类名称：单例模式模式 （懒汉式 只有需要时才创建）  单线程下
 * 类描述：确保一个类只有一个对象
 * 创建时间：2016年03月10日 下午22:19
 *
 * @author csypc
 * @version 1.0
 */
public class SingletonModel {
    public static void main(String[] args) {
        SingleModel model = SingleModel.getInstance();
        SingleModel model2 = SingleModel.getInstance();

        System.out.println(model);
        System.out.println(model2);
    }
}

class SingleModel{

    //声明一个私有的静态变量
    private static SingleModel singleModel = null;

    //构造器私有化，避免外部直接创建对象
    private SingleModel(){

    }

    //创建一个公有的方法访问变量，如果变量没有对象，则创建对象
    public static SingleModel getInstance(){
        if(null == singleModel){
            singleModel = new SingleModel();
        }
        return singleModel;
    }

}
