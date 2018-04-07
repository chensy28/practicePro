package com.csy.createthread.proxy;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ���̬����
 * ��������
 * ����ʱ�䣺2016��03��06�� ����21:46
 *
 * @author csypc
 * @version 1.0
 */
public class StaticProxy {
    //��̬���� ���ģʽ
    //��ʵ��ɫ
    //�����ɫ ��������ɫ��ɫ������
    //����ʵ����ͬ�Ľӿ�

    public static void main(String[] args) {
        You you = new You();
        MarryCompany marryCompany = new MarryCompany(you);
        marryCompany.marry();
    }

}

//��ʵ��ɫ
class You implements Marry{
    @Override
    public void marry(){
        System.out.println("xiaoli marry with a girl��");
    }
}

//�����ɫ
class MarryCompany implements Marry{

    private You you;
    public MarryCompany(){

    }

    //������ʵ��ɫ������
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

//�����ӿ�
interface Marry{
    void marry();
}
