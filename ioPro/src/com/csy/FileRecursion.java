package com.csy;

import java.io.File;

/**
 * 项目名称：
 * 类名称：
 * 类描述：利用递归列出全部文件
 * 创建时间：2016年03月17日 下午07:26
 *
 * @author csypc
 * @version 1.0
 */
public class FileRecursion {
    public static void main(String[] args) {
        File file = new File("H:\\iotest");
        show(file);
    }

    public static void show(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){  //若是目录，继续递归
                show(f);
            }else{  //找到文件，进行相应操作
                System.out.println(f.getName());
            }
        }
    }
}
