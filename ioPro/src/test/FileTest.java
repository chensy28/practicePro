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
        //路径分隔符
        String pathSeparator = File.pathSeparator;
        char pathChar = File.pathSeparatorChar;
        //名称分隔符
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
        file2.createNewFile(); //创建文件
        //file2.mkdir(); //创建目录
        //file2.delete();既可以删除文件、也可以删除目录
        /** 既可以是文件、也可以是目录 */
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
