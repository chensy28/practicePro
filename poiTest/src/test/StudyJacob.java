package test;
import com.jacob.activeX.ActiveXComponent;

import com.jacob.com.Dispatch;

import com.jacob.com.Variant;

import com.jacob.com.ComThread;

import java.util.List;

import java.util.ArrayList;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/11/3.
 * Time:23:51.
 */
public class StudyJacob {
    public static void main(String[] args) {

        ComThread.InitSTA();// ��ʼ��com���̣߳��ǳ���Ҫ����ʹ�ý�����Ҫ���� realease����
        ActiveXComponent objWord = new ActiveXComponent("Word.Application");
        Dispatch wordObject = (Dispatch) objWord.getObject();
        //Create a Dispatch Parameter to show the document that is opened
        Dispatch.put((Dispatch) wordObject, "Visible", new Variant(true));// new Variant(true)��ʾwordӦ�ó���ɼ�
        //Instantiate the Documents Property
        Dispatch documents = objWord.getProperty("Documents").toDispatch(); //documents��ʾword�������ĵ����ڣ���word�Ƕ��ĵ�Ӧ�ó���
        //Add a new word document, Current Active Document
        Dispatch document = Dispatch.call(documents, "Add").toDispatch(); // ʹ��Add�����һ�����ĵ�����Open������Դ�һ�������ĵ�
        Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // ȡ��word�ļ�������
        Dispatch.call(wordContent, "InsertAfter", "������һ�����������");//����һ������
        Dispatch.call(wordContent, "InsertAfter", "sdfsd��һ����fdsf");//
        Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs").toDispatch(); // ���ж���
        int paragraphCount = Dispatch.get(paragraphs, "Count").toInt(); // һ���Ķ�����
        // �ҵ�������Ķ��䣬���ø�ʽ
        Dispatch lastParagraph = Dispatch.call(paragraphs, "Item", new Variant(paragraphCount)).toDispatch(); // ���һ��
        Dispatch lastParagraphRange = Dispatch.get(lastParagraph, "Range"). toDispatch();
        Dispatch font = Dispatch.get(lastParagraphRange, "Font").toDispatch();
        Dispatch.put(font, "Bold", new Variant(true)); // ����Ϊ����
        Dispatch.put(font, "Italic", new Variant(true)); // ����Ϊб��
        Dispatch.put(font, "Name", new Variant("����")); //
        Dispatch.put(font, "Size", new Variant(12)); //С��

       // Dispatch button = Dispatch.get(document,"ActiveDocument").getDispatch();
       // button.put(button,"CheckBox",new Variant(true));

       /* String pid = documents.getProgramId();
        String pid2 = wordObject.getProgramId();
        String pid3 = paragraphs.getProgramId();
        String pid4 = font.getProgramId();*/

        List<Variant> disList = new ArrayList<>();
        /*for(int i =1 ;i<= 10;i++) {
            Variant temp = new Variant();
            if(!Dispatch.get(wordContent, i).isNull()){
                temp = Dispatch.get(wordContent, i);
            }
            disList.add(temp);
        }*/
        /*Variant temp = Dispatch.get(wordContent, 0);
        Variant temp2 = Dispatch.get(wordContent, 1);*/
        //Dispatch items = Dispatch.get(wordContent, "Item").toDispatch();
       // Dispatch.put(items,"Text",new Variant(true));

        //Method [] ms = wordContent.getClass().getMethods();
       /* for(int i=0;i<ms.length;i++){

        }*/

        //Dispatch.call(document, "SaveAs", new Variant("C:/abc.doc")); // ����һ�����ĵ�
        System.out.print("�����ٶ��ٷַ���");
        ComThread.Release();//�ͷ�com�̡߳�����jacob�İ����ĵ���com���̻߳��ղ���java����������������
    }
}
