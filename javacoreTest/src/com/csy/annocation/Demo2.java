//@MyAnnotation
package com.csy.annocation;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�Demo2
 * �������������Զ���ע�� @Targetʹ��
 * ����ʱ�䣺2016��01��27�� ����23:19
 *
 * @author csypc
 * @version 1.0
 */
@MyAnnotation                                  //��������
public class Demo2 {
    @MyAnnotation(value="aa")                              //�����ڳ�Ա����
    private String ano;
    @MyAnnotation (arr={"dd","gg"})                            //�����ڷ���

    public void show( @MyAnnotation String s){  //�����ڲ���

        @MyAnnotation2                         // ��������һ��ע��
        @MyAnnotation                         //�����ڳ�Ա����
         String str;
    }

}
