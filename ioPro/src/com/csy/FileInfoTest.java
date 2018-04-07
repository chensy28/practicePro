package com.csy;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��15�� ����07:53
 *
 * @author csypc
 * @version 1.0
 */
public class FileInfoTest {
    public static void main(String[] args) {
        /**
         * �����ļ���ʽ(����·��)
         */
        //File file = new File("H:\\iotest\\file.txt"); //File(String pathname)
        //File file = new File("H:\\iotest","a.txt");   //File(String parent, String child)
        File file = new File(new File("H:\\iotest"),"b.txt"); //File(File parent, String child)
        //���·��
        //File file = new File("c.txt"); //��Ը�Ŀ¼ ��ideaworkspaceĿ¼��
        // File file = new File("ioPro\\src\\com\\csy\\d.txt");  //����ڵ�ǰ��
        if(!file.exists()){
            try {
                file.createNewFile();//���ļ����ڣ��������ļ������ҷ���false���������ڲ��Ҵ����ɹ�������false
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //����Ŀ¼(mkdir() �� mkdirs()���� :
        // mkdir���������˳���·������ָ����Ŀ¼����ֻ�ܴ���һ����Ŀ¼������Ҫ���ڸ�Ŀ¼��
            // mkdirs���������˳���·��ָ����Ŀ¼���������б��뵫�����ڵĸ�Ŀ¼���������Դ����༶Ŀ¼�������Ƿ���ڸ�Ŀ¼��)

        /*File filedir = new File("H:\\iotest\\csy\\ui\\rt\\yu");//�ϼ�Ŀ¼����ڣ��紴��yu��rt�ͱ������
        System.out.println(filedir.mkdir());*/

        /**
         * ����Ŀ¼
         */
        File filedir2 = new File("H:\\iotest\\csy2\\aa\\ii\\kk\\yy");//�����༶Ŀ¼���ϼ�Ŀ¼��һ������
        System.out.println("createDir:"+filedir2.mkdirs());

        /**
         * ɾ���ļ�
         */
        //System.out.println("delete:"+filedir2.delete());
        //deleteɾ��һ��Ŀ¼���ļ�����ɾ��Ŀ¼ʱ��Ŀ¼�±���Ϊ�ղ���ɾ��
        //System.out.println("delete:"+file.delete());
        //��JVM�����˳���ʱ��ɾ���ļ�,ͨ��������ʱ�ļ���ɾ��.
        //file.deleteOnExit();

        /**
         * �жϷ���
         * 1.boolean canExecute()�ж��ļ��Ƿ��ִ��
         2.boolean canRead()�ж��ļ��Ƿ�ɶ�
         3.boolean canWrite() �ж��ļ��Ƿ��д
         4.boolean exists() �ж��ļ��Ƿ����
         5.boolean isDirectory()
         6.boolean isFile()
         7.boolean isHidden()
         8.boolean isAbsolute()�ж��Ƿ��Ǿ���·�� �ļ�������Ҳ���ж�
         */
        System.out.println("--------�жϷ���---------");
        file.setExecutable(false);
        file.setReadable(false);
        file.setReadOnly();//ֻ�ܶ�����ж�������
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
         4.String getParent()//���û�и�Ŀ¼����null
         5.long lastModified()//��ȡ���һ���޸ĵ�ʱ��
         6.long length()
         7.boolean renameTo(File f)
         8.File[] liseRoots()//��ȡ�����̷�
         9.String[] list()
         10.String[] list(FilenameFilter filter)
         */
        System.out.println("--------��ȡ����---------");
        System.out.println("1:"+file.getName());
        System.out.println("2:"+filedir2.getPath());
        System.out.println("3:"+filedir2.getAbsolutePath());
        System.out.println("4:"+filedir2.getParent());
        System.out.println("5:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(filedir2.lastModified())));//����long��
        System.out.println("6:"+file.length());
        file.renameTo(new File("H:\\iotest\\csy\\ffsss.txt"));
        System.out.println("aaaaa");
        //�г����õ��ļ�ϵͳ���� (��ȡ�����̷�)
    /*    File[] files = File.listRoots();
        for(File file1:files){
            System.out.println(file1);
            if (files.length > 0) {
                String[] filenames = file1.list();//����ָ��Ŀ¼�е��ļ���Ŀ¼
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

        //����ָ��Ŀ¼�µ������ļ����ƣ�
        String[] strs = filedir2.list();//����˳���·��������ʾһ��Ŀ¼����ô�˷��������� null
        System.out.println("file.list:");
        for(String str : strs){
            System.out.print(str + "\t");
        }

        //
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {//������򣬰�Ϊtrue���ļ�name����
               // System.out.println("wowowowowow");
                return name.endsWith(".exe");
            }
        };

        String []arr = filedir2.list(filter);
        for(String str : arr){
            System.out.println("filter:"+str);
        }

        //filter.accept(new File("H:\\iotest\\csy2\\aa\\ii\\kk\\yy"),"a.txt");

      /*  System.out.print("filter��");
        String[] filterNames = filedir2.list(filter);
        for (String s : filterNames){
            System.out.print(s + "\t");
        }
*/
    }
}
