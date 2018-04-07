package com.csy;

import java.io.File;

/**
 * 项目名称：
 * 类名称：
 * 类描述：重命名文件，并拷贝到指定目录
 * 创建时间：2016年03月17日 下午07:38
 *
 * @author csypc
 * @version 1.0
 */
public class FileMove {
    public static void main(String[] args) {
        File dst = new File("H:\\iotest\\dst");
        if(!dst.exists()){
            dst.mkdir();
        }

        File src = new File("H:\\iotest");
        move(src,dst);
    }

    public static void move(File file,File dst){
        /*System.out.println("path:"+dst.getPath());
        System.out.println(dst.getAbsolutePath());*/
        File[] files = file.listFiles();
        for (File f : files){
            if(f.isDirectory()){
               move(f,dst);
            }else{
                //重命名并移动到指定的目录
                //f.renameTo(new File(dst.getPath()+f.getName().substring(0, f.getName().indexOf("."))+".jab"));
                //f.renameTo(new File("H:\\"+f.getName().substring(0, f.getName().indexOf("."))+".jab"));
                f.renameTo(new File("H:\\aj.txt"));
            }
        }
    }
}
