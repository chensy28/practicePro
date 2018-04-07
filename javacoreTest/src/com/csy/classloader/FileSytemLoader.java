package com.csy.classloader;

import java.io.*;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ���������Զ�������������̳�ClassLoader�ࣩ
 * ����ʱ�䣺2016��03��04�� ����08:51
 *
 * @author csypc
 * @version 1.0
 */
public class FileSytemLoader extends ClassLoader{
    private String rootDir;

    public FileSytemLoader(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        //�ж����Ƿ񱻼��ع��������ع���ֱ�ӷ��أ�
        if(c != null){
            return c;
        }else {
            //��û�м��أ�ί�ɸ�����������
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            }catch (Exception e){
                //e.printStackTrace();
            }
            if(c != null){
                return c;
            }else{
                //��������û�м��أ���ͨ��io��ȡ�ļ�����ȡ�ֽ����飬��ת��Ϊclass����
                byte [] classData = getClassData(name);
                if(classData == null){
                    throw new ClassNotFoundException();
                }else{
                    //������� ���������ƣ������֪�������ƣ���ò���Ϊ null
                    c = defineClass(null,classData,0,classData.length);
                    return c;
                }
            }
        }

    }

    public byte[] getClassData(String className){
        String path = rootDir + "/" +className.replace(".","/")+".class";

        InputStream is = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte [] arrs = new byte[1024];
            int temp = 0;
            while((temp = is.read(arrs)) != -1){     //�����������ж�ȡ������д���������
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

