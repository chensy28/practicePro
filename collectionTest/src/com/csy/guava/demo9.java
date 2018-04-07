package com.csy.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;


/**
 * 项目名称：springbasic
 * 类名称：demo9
 * 类描述：Table使用，有两个键
 * 创建时间：2016年01月21日 下午09:08
 *
 * @author csypc
 * @version 1.0
 */
public class demo9 {
    public static void main(String[] args) {
        Table<String,String,String> table = HashBasedTable.create();
        table.put("a","yunwen","70");
        table.put("b","shuxue","80");
        //若rowkey+colkey相同，则更新对应的值
        //table.put("b","shuxue","88");
        table.put("a","shuxue","90");
        table.put("c","yingyu","100");

        //获取所有的单元格
        Set<Table.Cell<String,String,String>> cellSet = table.cellSet();
        for(Table.Cell<String,String,String> cell : cellSet){
            //每个单元格由rowkey+colkey+value组成
            System.out.println(cell.getRowKey()+":"+cell.getColumnKey()+":"+cell.getValue());
        }

        //获取colkey对应的视图Map<R,V>
        Map<String,String> map = table.column("shuxue");
        System.out.println(map);

        //获取所有列的键的集合
        Set<String> colKeySet = table.columnKeySet();
        System.out.println(colKeySet);

        //获取colkey对应的map
        Map<String,Map<String,String>> columnMap = table.columnMap();
        System.out.println(columnMap);

        //是否包含colkey，rowkey，value
        boolean isColkey = table.containsColumn("shuxue2");
        boolean isRowkey = table.containsRow("a2");
        boolean isValue = table.containsValue("200");
        System.out.println(isColkey+":"+isRowkey+":"+isValue);


       //获取rowkey对应的map
        Map<String,String> row = table.row("a");
        System.out.println(row);

        Map<String,Map<String,String>> rowMap = table.rowMap();
        System.out.println(rowMap);
    }
}
