package com.csy.nestedclass;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ���������ڲ������
 * ����ʱ�䣺2016��03��05�� ����23:51
 *
 * @author csypc
 * @version 1.0
 */
public class Introduce {

    //�ڲ�����Ȼ��һ���������࣬�ڱ���֮���ڲ���ᱻ����ɶ�����.class�ļ�������ǰ������ⲿ���������$����
    //�ڲ�����������η�public��private��static�����Σ��൱���ⲿ��ĳ�Ա

    //---------��̬�ڲ���------------------
    static class StaticClass{

    }

    // --------�Ǿ�̬�ڲ���------------------
    //��ͨ�ڲ���
    private class CommonClass{

    }

    //�����ڲ���
    public void methodNestedClass(){
        class MethodClass{

        }

        //�����ڲ���(Ҳ�Ƿ����ڲ���)
        Run run = new Run() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

}
