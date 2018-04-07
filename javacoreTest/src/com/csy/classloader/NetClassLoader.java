package com.csy.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：自定义类加载器（继承ClassLoader类）
 * 创建时间：2016年03月04日 下午08:51
 *
 * @author csypc
 * @version 1.0
 */
public class NetClassLoader extends ClassLoader{
    private String rootUrl;

    public NetClassLoader(String rootUrl){
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        //判断类是否被加载过，若加载过，直接返回；
        if(c != null){
            return c;
        }else {
            //若没有加载，委派父加载器加载
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            }catch (Exception e){
                //e.printStackTrace();
            }
            if(c != null){
                return c;
            }else{
                //若加载器没有加载，则通过io读取文件，获取字节数组，并转换为class对象
                byte [] classData = getClassData(name);
                if(classData == null){
                    throw new ClassNotFoundException();
                }else{
                    //所需类的 二进制名称，如果不知道此名称，则该参数为 null
                    c = defineClass(null,classData,0,classData.length);
                    return c;
                }
            }
        }

    }

    public byte[] getClassData(String className){
        String path = rootUrl + "/" +className.replace(".","/")+".class";

        InputStream is = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            //创建URL
            URL url = new URL(path);
            is = url.openStream();

            byte [] arrs = new byte[1024];
            int temp = 0;
            while((temp = is.read(arrs)) != -1){     //将从输入流中读取的数据写到输出流中
                out.write(arrs,0,temp);
            }
            return out.toByteArray();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try {
                is.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }


}


