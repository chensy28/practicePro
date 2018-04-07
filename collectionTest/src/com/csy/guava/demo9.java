package com.csy.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;


/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo9
 * ��������Tableʹ�ã���������
 * ����ʱ�䣺2016��01��21�� ����09:08
 *
 * @author csypc
 * @version 1.0
 */
public class demo9 {
    public static void main(String[] args) {
        Table<String,String,String> table = HashBasedTable.create();
        table.put("a","yunwen","70");
        table.put("b","shuxue","80");
        //��rowkey+colkey��ͬ������¶�Ӧ��ֵ
        //table.put("b","shuxue","88");
        table.put("a","shuxue","90");
        table.put("c","yingyu","100");

        //��ȡ���еĵ�Ԫ��
        Set<Table.Cell<String,String,String>> cellSet = table.cellSet();
        for(Table.Cell<String,String,String> cell : cellSet){
            //ÿ����Ԫ����rowkey+colkey+value���
            System.out.println(cell.getRowKey()+":"+cell.getColumnKey()+":"+cell.getValue());
        }

        //��ȡcolkey��Ӧ����ͼMap<R,V>
        Map<String,String> map = table.column("shuxue");
        System.out.println(map);

        //��ȡ�����еļ��ļ���
        Set<String> colKeySet = table.columnKeySet();
        System.out.println(colKeySet);

        //��ȡcolkey��Ӧ��map
        Map<String,Map<String,String>> columnMap = table.columnMap();
        System.out.println(columnMap);

        //�Ƿ����colkey��rowkey��value
        boolean isColkey = table.containsColumn("shuxue2");
        boolean isRowkey = table.containsRow("a2");
        boolean isValue = table.containsValue("200");
        System.out.println(isColkey+":"+isRowkey+":"+isValue);


       //��ȡrowkey��Ӧ��map
        Map<String,String> row = table.row("a");
        System.out.println(row);

        Map<String,Map<String,String>> rowMap = table.rowMap();
        System.out.println(rowMap);
    }
}
