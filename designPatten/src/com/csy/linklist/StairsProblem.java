package com.csy.linklist;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年04月17日 下午00:18
 *
 * @author csypc
 * @version 1.0
 */
public class StairsProblem {
    public static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            String title = (String) list.get(i);
            System.out.println("第" + (i + 1) + "种走法：" + title);
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

        String step1 = "1";//1个台阶走法
        String step2 = "11";//2个台阶走法
        String step3 = "2";

        List wayList1 = new ArrayList();//保存走法
        wayList1.add(step1);
        List wayList2 = new ArrayList();//保存走法
        wayList2.add(step2);
        wayList2.add(step3);

        List temp1, temp2;//临时保存走法
        List wayList = new ArrayList();//保存走法
        //No.1
        //开始写代码，补充完整for循环，求出走台阶的所有走法并输出
        for ( ) {




        }
        //end_code
        System.out.println("走法总共有：" + way3 + "种");
        System.out.println("走法如下：");
        print(wayList);
    }
}
