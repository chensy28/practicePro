package test;


import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/4.
 * Time:8:19.
 */
public class FileTest {
    public static void  main(String []args) throws IOException {
        //·���ָ���
        String pathSeparator = File.pathSeparator;
        char pathChar = File.pathSeparatorChar;
        //���Ʒָ���
        String separator = File.separator;
        char sepaChar = File.separatorChar;
        /*System.out.println(pathSeparator);
        System.out.println(pathChar);
        System.out.println(separator);
        System.out.println(sepaChar);*/

        File file = new File("h:\\iotest");
        //file.createnewfile();
       // file.mkdir();
        //system.out.print(file.exists());

       /* file file2 = new file("h:\\iotest\\io.txt");
        file2.createnewfile();*/
        File file2 = new File(file,"bb.txt");
        //File file2 = new File("H:\\iotest\\fkkd");
        file2.createNewFile(); //�����ļ�
        //file2.mkdir(); //����Ŀ¼
        //file2.delete();�ȿ���ɾ���ļ���Ҳ����ɾ��Ŀ¼
        /** �ȿ������ļ���Ҳ������Ŀ¼ */
       /* System.out.println(file2.canRead());
        System.out.println(file2.canExecute());
        System.out.println(file2.canWrite());
        System.out.println(file2);
        System.out.print(file2.exists());*/
        //System.out.print(file2.getAbsoluteFile());
        file2.getParent();
        System.out.print(file2.getCanonicalFile());
        System.out.print(file2.getPath());
    }
}
