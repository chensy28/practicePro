package com.csy.nestedclass;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ������������neibulei
 * ����ʱ�䣺2016��03��06�� ����11:51
 *
 * @author csypc
 * @version 1.0
 */
public class AnonymousNestedClass {

     //�ӿ�ʽ
     Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
     };

    //�̳�ʽ
    Car car = new Car(){
      @Override
      public void run(){
          run();
          System.out.println("aaa�����������ܣ�");
      }
    };

    //����ʽ
    public void test(Car car){
         car.run();
    }


    //����
    public static void main(String[] args) {
        AnonymousNestedClass clazz = new AnonymousNestedClass();
        clazz.test(new Car(){});
        System.out.println(clazz.car);

    }
}

class Car{
    public void run(){
        System.out.println("sss�������ܣ�");
    }
}
