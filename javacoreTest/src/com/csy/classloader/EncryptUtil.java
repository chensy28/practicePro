package com.csy.classloader;

import java.io.*;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月05日 下午07:59
 *
 * @author csypc
 * @version 1.0
 */
public class EncryptUtil {

    public static void main(String[] args) {
        encrypt("H:/myjavatest/com/csy/HelloWorld.class","H:/myjavatest/com/csy/temp/HelloWorld.class");
    }

    public static void encrypt(String src,String desc){
        try {
            InputStream is = new FileInputStream(new File(src));
            OutputStream os = new FileOutputStream(new File(desc));

            int temp = -1;
            //按单字节读取，返回0到255之间的int的字节值，若没有可用的字节，则返回-1
            try {
                while((temp = is.read()) != -1){
                    //加密（将原来的内容取反）
                    os.write(temp ^ 0xff);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //关闭流
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
