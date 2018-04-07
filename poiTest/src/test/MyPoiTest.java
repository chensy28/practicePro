package test;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/11/2.
 * Time:20:31.
 */

import com.jacob.com.InvocationProxy;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.jacob.activeX.ActiveXDispatchEvents;
import com.jacob.com.ComThread;

public class MyPoiTest {
    //ʹ��POI����excel������
    public static void createWorkBook() throws IOException {
        //����excel������
        Workbook wb = new HSSFWorkbook();
        //������һ��sheet��ҳ��������Ϊ new sheet
        Sheet sheet = wb.createSheet("new sheet");
        //Row ��
        //Cell ����
        // Row �� Cell ���Ǵ�0��ʼ������
        Row row1 = sheet.createRow(4);
        Cell var1 = row1.createCell(6);
        var1.setCellValue("c");

        Row row2 = sheet.createRow(5);
        Cell var2 = row2.createCell(7);
        var2.setCellValue("s");

        Row row3 = sheet.createRow(6);
        Cell var3 = row3.createCell(8);
        var3.setCellValue("y");

        //����һ���ļ� ����Ϊworkbook.xls
        FileOutputStream fileOut = new FileOutputStream("csyworkbook.xls");
        // �����洴���Ĺ�����������ļ���?
        wb.write(fileOut);
        //�ر������?
        fileOut.close();
    }

    //ʹ��POI����excel�������ļ�
    public static void readWorkBook() throws Exception {
        // poi��ȡexcel
        //����Ҫ������ļ���������?
        InputStream inp = new FileInputStream("csyworkbook.xls");

        //�������������������� ��������������
        Workbook wb = null;
                //WorkbookFactory.create(inp);
        //�õ���һҳ sheet
        //ҳSheet�Ǵ�0��ʼ������
        Sheet sheet = wb.getSheetAt(0);
        System.out.println(sheet.getRow(9).getCell(4));
        //����foreachѭ�� ����sheet�е�������
       /* for (Row row : sheet) {
            //����row�е����з���
            for (Cell cell : row) {
                //��������е����ݣ��Կո���?
                System.out.print(cell.toString() + "  ");
            }
            //ÿһ�������֮����?
            System.out.println();
        }*/
        //�ر�������
        inp.close();
    }

   /* protected InvocationProxy event(ActiveXDispatchEvents act,Object obj){
       // return act.getInvocationProxy(obj)
    }*/

    public static void main(String[] args) throws Exception {
        //MyPoiTest.createWorkBook();
        //readWorkBook();
        Object recive = new Object();
        ComThread.InitSTA();
       ActiveXComponent word=new ActiveXComponent("Word.Application");
        Dispatch documents = word.getProperty("Documents").toDispatch();
        Dispatch document = Dispatch.call(documents, "Open", "d:/poitest.doc").toDispatch();

    //    ComThread.Release();

        /*ActiveXDispatchEvents events = new ActiveXDispatchEvents(document,recive);
        events.getInvocationProxy(recive);*/
        //Variant result =Dispatch.call(word, "Run", new Variant("macro1"));
        //Variant result =Dispatch.call(word, "Run", new Variant("CommandButton1_Click"));
        /*ActiveXComponent excel =new ActiveXComponent("Excel.Application");
        Dispatch documents = excel.getProperty("Workbooks").toDispatch();
        Dispatch document = Dispatch.call(documents, "Open", "E:/ideaworkspace/csy.xls").toDispatch();
        Variant result =Dispatch.call(excel, "Run", new Variant("csy"));
        System.out.print(result.getString());*/
    }
}
