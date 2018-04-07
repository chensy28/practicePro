package com.csy.createthread;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�����ģʽģʽ ������ʽ ֻ����Ҫʱ�Ŵ�����  ���߳���
 * ��������ȷ��һ����ֻ��һ������
 * ����ʱ�䣺2016��03��10�� ����22:19
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

    //����һ��˽�еľ�̬����
    private static SingleModel singleModel = null;

    //������˽�л��������ⲿֱ�Ӵ�������
    private SingleModel(){

    }

    //����һ�����еķ������ʱ������������û�ж����򴴽�����
    public static SingleModel getInstance(){
        if(null == singleModel){
            singleModel = new SingleModel();
        }
        return singleModel;
    }

}
