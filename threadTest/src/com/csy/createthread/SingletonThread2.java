package com.csy.createthread;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�����ģʽ ����ʽ
 * ��������
 * ����ʱ�䣺2016��03��11�� ����00:36
 *
 * @author csypc
 * @version 1.0
 */
public class SingletonThread2 {
    public static void main(String[] args) {
       /* SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        SingleTon singleTon3 = SingleTon.getInstance();

        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon3.hashCode());*/

        SingleTonTest singleTon1 = SingleTonTest.getInstance();
        SingleTonTest singleTon2 = SingleTonTest.getInstance();
        SingleTonTest singleTon3 = SingleTonTest.getInstance();

        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon3.hashCode());


    }
}

class SingleTon{
    //������̬�ı��������ҽ��г�ʼ��
    private static SingleTon singleTon = new SingleTon(); //--->������ʽ����֮��
    //��������˽�й�����
    private SingleTon(){}

    //�����ṩ���ʱ����Ĺ��з�������Ϊʵ���������ʱ�ͱ������ˣ�����ֱ�ӷ���
    public static SingleTon getInstance(){
        return singleTon;   //--->������ʽ����֮��
    }
}

//�ڲ���д��
class SingleTonTest{
    static class Nested{
        private static SingleTonTest singleTonTest = new SingleTonTest();
    }

    private SingleTonTest(){}

    public static SingleTonTest getInstance(){
        return Nested.singleTonTest;
    }
}
