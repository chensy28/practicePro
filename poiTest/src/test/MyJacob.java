package test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;

import com.jacob.com.DispatchEvents;
import com.jacob.com.Variant;
import com.jacob.com.Dispatch;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/11/3.
 * Time:23:51.
 */
public class MyJacob {
    public static void main(String[] args) {

        ComThread.InitSTA();// 初始化com的线程，非常重要！！使用结束后要调用 realease方法
        ActiveXComponent objWord = new ActiveXComponent("Word.Application");

        Dispatch doc = objWord.getProperty("Application").toDispatch();
        //Variant doc2 =Dispatch.get(doc, "ActiveCell");
        Dispatch documents = objWord.getProperty("Documents").toDispatch();
        //Variant v = Dispatch.get(documents, "ActiveCell");
        Dispatch document = Dispatch.call(documents, "Open", "d:/poitest.doc").toDispatch();
        //Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // 取得word文件的内容
        //Long pdis = wordContent.m_pDispatch;
        //Variant result =Dispatch.call(objWord, "Run", new Variant("macro1"));
        //Dispatch.
        //Dispatch.put(document, "Visible", new Variant(true));// new Variant(true)表示word应用程序可见
        //Variant temp = Dispatch.get(wordContent,0);
        //System.out.print(temp.getString());

        ListenEvent listenEvent = new ListenEvent();
        DispatchEvents events = new DispatchEvents(documents,listenEvent);
       // events.
        //Dispatch.callSub();
        System.out.print("发多少多少分分类");
        ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
    }
}
