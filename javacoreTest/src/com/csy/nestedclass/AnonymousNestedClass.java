package com.csy.nestedclass;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：匿名neibulei
 * 创建时间：2016年03月06日 下午11:51
 *
 * @author csypc
 * @version 1.0
 */
public class AnonymousNestedClass {

     //接口式
     Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
     };

    //继承式
    Car car = new Car(){
      @Override
      public void run(){
          run();
          System.out.println("aaa子类汽车在跑！");
      }
    };

    //参数式
    public void test(Car car){
         car.run();
    }


    //测试
    public static void main(String[] args) {
        AnonymousNestedClass clazz = new AnonymousNestedClass();
        clazz.test(new Car(){});
        System.out.println(clazz.car);

    }
}

class Car{
    public void run(){
        System.out.println("sss汽车在跑！");
    }
}
