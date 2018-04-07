package com.csy;

import java.io.*;

/**
 * 项目名称：
 * 类名称：
 * 类描述：文件输入输出流
 * 创建时间：2016年03月22日 下午08:13
 *
 * @author csypc
 * @version 1.0
 */
public class FileInputOutStreamTest {
    public static void main(String[] args) {
        File file = new File("h:\\iotest\\file.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                //e.printStackTrace();打印出轨迹
                throw new RuntimeException(e);
            }
        }
        try {
            //把数据写入输出流
            FileOutputStream outputStream = new FileOutputStream(file);
            byte []b = {1,3,4,5,'a','b'};
            outputStream.write(b);

            //从输入流读入数据
            FileInputStream inputStream = new FileInputStream(file);
            byte []c = new byte[1024];
            int size = inputStream.read(c);
            for(int i=0;i<size;i++){
                System.out.print(c[i]+"\t");
            }

            //记得用完流以后要关闭流，不然会耗尽资源
            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
