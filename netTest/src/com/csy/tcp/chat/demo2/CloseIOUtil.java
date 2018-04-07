package com.csy.tcp.chat.demo2;

import java.io.Closeable;
import java.io.IOException;

/**
 * 项目名称：
 * 类名称：
 * 类描述：关闭流工具
 * 创建时间：2016年04月04日 下午22:21
 *
 * @author csypc
 * @version 1.0
 */
public class CloseIOUtil {
    public static void closeAll(Closeable... ios){
        for(Closeable temp : ios){
            if(temp != null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
