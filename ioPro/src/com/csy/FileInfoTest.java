package com.csy;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月15日 下午07:53
 *
 * @author csypc
 * @version 1.0
 */
public class FileInfoTest {
    public static void main(String[] args) {
        /**
         * 创建文件方式(绝对路径)
         */
        //File file = new File("H:\\iotest\\file.txt"); //File(String pathname)
        //File file = new File("H:\\iotest","a.txt");   //File(String parent, String child)
        File file = new File(new File("H:\\iotest"),"b.txt"); //File(File parent, String child)
        //相对路径
        //File file = new File("c.txt"); //相对根目录 在ideaworkspace目录下
        // File file = new File("ioPro\\src\\com\\csy\\d.txt");  //相对于当前包
        if(!file.exists()){
            try {
                file.createNewFile();//若文件存在，不创建文件，并且返回false；若不存在并且创建成功，返回false
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //创建目录(mkdir() 与 mkdirs()区别 :
        // mkdir（）创建此抽象路径名称指定的目录（及只能创建一级的目录，且需要存在父目录）
            // mkdirs（）创建此抽象路径指定的目录，包括所有必须但不存在的父目录。（及可以创建多级目录，无论是否存在父目录）)

        /*File filedir = new File("H:\\iotest\\csy\\ui\\rt\\yu");//上级目录需存在，如创建yu，rt就必须存在
        System.out.println(filedir.mkdir());*/

        /**
         * 创建目录
         */
        File filedir2 = new File("H:\\iotest\\csy2\\aa\\ii\\kk\\yy");//创建多级目录，上级目录不一定存在
        System.out.println("createDir:"+filedir2.mkdirs());

        /**
         * 删除文件
         */
        //System.out.println("delete:"+filedir2.delete());
        //delete删除一个目录或文件，若删除目录时，目录下必须为空才能删除
        //System.out.println("delete:"+file.delete());
        //在JVM进程退出的时候删除文件,通常用在临时文件的删除.
        //file.deleteOnExit();

        /**
         * 判断方法
         * 1.boolean canExecute()判断文件是否可执行
         2.boolean canRead()判断文件是否可读
         3.boolean canWrite() 判断文件是否可写
         4.boolean exists() 判断文件是否存在
         5.boolean isDirectory()
         6.boolean isFile()
         7.boolean isHidden()
         8.boolean isAbsolute()判断是否是绝对路径 文件不存在也能判断
         */
        System.out.println("--------判断方法---------");
        file.setExecutable(false);
        file.setReadable(false);
        file.setReadOnly();//只能对其进行读操作。
        System.out.println("1:"+file.canExecute());
        System.out.println("2:"+file.canRead());
        System.out.println("3:"+file.canWrite());
        System.out.println("4:"+file.exists());
        System.out.println("5:"+file.isDirectory());
        System.out.println("6:"+file.isFile());
        System.out.println("7:"+file.isHidden());
        System.out.println("8:"+file.isAbsolute());

        /**
         * 1.String getName()
         2.String getPath()
         3.String getAbsolutePath()
         4.String getParent()//如果没有父目录返回null
         5.long lastModified()//获取最后一次修改的时间
         6.long length()
         7.boolean renameTo(File f)
         8.File[] liseRoots()//获取机器盘符
         9.String[] list()
         10.String[] list(FilenameFilter filter)
         */
        System.out.println("--------获取方法---------");
        System.out.println("1:"+file.getName());
        System.out.println("2:"+filedir2.getPath());
        System.out.println("3:"+filedir2.getAbsolutePath());
        System.out.println("4:"+filedir2.getParent());
        System.out.println("5:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(filedir2.lastModified())));//返回long型
        System.out.println("6:"+file.length());
        file.renameTo(new File("H:\\iotest\\csy\\ffsss.txt"));
        System.out.println("aaaaa");
        //列出可用的文件系统根。 (获取机器盘符)
    /*    File[] files = File.listRoots();
        for(File file1:files){
            System.out.println(file1);
            if (files.length > 0) {
                String[] filenames = file1.list();//返回指定目录中的文件和目录
                if(filenames != null) {
                    for (String filename : filenames) {
                        System.out.println(filename);
                    }
                }
            }
        }*/
        System.out.println("aaaaa");
        /*for(File file1 : files){
            System.out.print("\t"+file1);  //C:\  D:\	E:\	  F:\	G:\	H:\
        }*/

        //返回指定目录下的所有文件名称，
        String[] strs = filedir2.list();//如果此抽象路径名不表示一个目录，那么此方法将返回 null
        System.out.println("file.list:");
        for(String str : strs){
            System.out.print(str + "\t");
        }

        //
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {//定义规则，把为true的文件name返回
               // System.out.println("wowowowowow");
                return name.endsWith(".exe");
            }
        };

        String []arr = filedir2.list(filter);
        for(String str : arr){
            System.out.println("filter:"+str);
        }

        //filter.accept(new File("H:\\iotest\\csy2\\aa\\ii\\kk\\yy"),"a.txt");

      /*  System.out.print("filter：");
        String[] filterNames = filedir2.list(filter);
        for (String s : filterNames){
            System.out.print(s + "\t");
        }
*/
    }
}
