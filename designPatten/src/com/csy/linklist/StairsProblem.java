package com.csy.linklist;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��04��17�� ����00:18
 *
 * @author csypc
 * @version 1.0
 */
public class StairsProblem {
    public static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            String title = (String) list.get(i);
            System.out.println("��" + (i + 1) + "���߷���" + title);
        }
    }

    public static ArrayList addPre(List list, int num) {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String title = (String) list.get(i);
            title  = num + title;
            arraylist.add(title);
        }
        return arraylist;
    }

    public static void main(String[] args) {
        int way1 = 1, way2 = 2, way3 = 0;

        String step1 = "1";//1��̨���߷�
        String step2 = "11";//2��̨���߷�
        String step3 = "2";

        List wayList1 = new ArrayList();//�����߷�
        wayList1.add(step1);
        List wayList2 = new ArrayList();//�����߷�
        wayList2.add(step2);
        wayList2.add(step3);

        List temp1, temp2;//��ʱ�����߷�
        List wayList = new ArrayList();//�����߷�
        //No.1
        //��ʼд���룬��������forѭ���������̨�׵������߷������
        for ( ) {




        }
        //end_code
        System.out.println("�߷��ܹ��У�" + way3 + "��");
        System.out.println("�߷����£�");
        print(wayList);
    }
}
