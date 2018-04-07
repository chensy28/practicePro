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

        ComThread.InitSTA();// 初始化com的线程，非常重要！！使用结束后要调用 realease方法
        ActiveXComponent objWord = new ActiveXComponent("Word.Application");
        Dispatch wordObject = (Dispatch) objWord.getObject();
        //Create a Dispatch Parameter to show the document that is opened
        Dispatch.put((Dispatch) wordObject, "Visible", new Variant(true));// new Variant(true)表示word应用程序可见
        //Instantiate the Documents Property
        Dispatch documents = objWord.getProperty("Documents").toDispatch(); //documents表示word的所有文档窗口，（word是多文档应用程序）
        //Add a new word document, Current Active Document
        Dispatch document = Dispatch.call(documents, "Add").toDispatch(); // 使用Add命令创建一个新文档，用Open命令可以打开一个现有文档
        Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // 取得word文件的内容
        Dispatch.call(wordContent, "InsertAfter", "这里是一个段落的内容");//插入一个段落
        Dispatch.call(wordContent, "InsertAfter", "sdfsd是一个段fdsf");//
        Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs").toDispatch(); // 所有段落
        int paragraphCount = Dispatch.get(paragraphs, "Count").toInt(); // 一共的段落数
        // 找到刚输入的段落，设置格式
        Dispatch lastParagraph = Dispatch.call(paragraphs, "Item", new Variant(paragraphCount)).toDispatch(); // 最后一段
        Dispatch lastParagraphRange = Dispatch.get(lastParagraph, "Range"). toDispatch();
        Dispatch font = Dispatch.get(lastParagraphRange, "Font").toDispatch();
        Dispatch.put(font, "Bold", new Variant(true)); // 设置为黑体
        Dispatch.put(font, "Italic", new Variant(true)); // 设置为斜体
        Dispatch.put(font, "Name", new Variant("宋体")); //
        Dispatch.put(font, "Size", new Variant(12)); //小四

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

        //Dispatch.call(document, "SaveAs", new Variant("C:/abc.doc")); // 保存一个新文档
        System.out.print("发多少多少分分类");
        ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
    }
}
