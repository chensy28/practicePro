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
    //使锟斤拷POI锟斤拷锟斤拷excel锟斤拷锟斤拷锟斤拷
    public static void createWorkBook() throws IOException {
        //锟斤拷锟斤拷excel锟斤拷锟斤拷锟斤拷
        Workbook wb = new HSSFWorkbook();
        //锟斤拷锟斤拷锟斤拷一锟斤拷sheet锟斤拷页锟斤拷锟斤拷锟斤拷锟斤拷为 new sheet
        Sheet sheet = wb.createSheet("new sheet");
        //Row 锟斤拷
        //Cell 锟斤拷锟斤拷
        // Row 锟斤拷 Cell 锟斤拷锟角达拷0锟斤拷始锟斤拷锟斤拷锟斤拷
        Row row1 = sheet.createRow(4);
        Cell var1 = row1.createCell(6);
        var1.setCellValue("c");

        Row row2 = sheet.createRow(5);
        Cell var2 = row2.createCell(7);
        var2.setCellValue("s");

        Row row3 = sheet.createRow(6);
        Cell var3 = row3.createCell(8);
        var3.setCellValue("y");

        //锟斤拷锟斤拷一锟斤拷锟侥硷拷 锟斤拷锟斤拷为workbook.xls
        FileOutputStream fileOut = new FileOutputStream("csyworkbook.xls");
        // 锟斤拷锟斤拷锟芥创锟斤拷锟侥癸拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷锟?
        wb.write(fileOut);
        //锟截憋拷锟斤拷锟斤拷锟?
        fileOut.close();
    }

    //使锟斤拷POI锟斤拷锟斤拷excel锟斤拷锟斤拷锟斤拷锟侥硷拷
    public static void readWorkBook() throws Exception {
        // poi锟斤拷取excel
        //锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷募锟斤拷锟斤拷锟斤拷锟斤拷锟?
        InputStream inp = new FileInputStream("csyworkbook.xls");

        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
        Workbook wb = null;
                //WorkbookFactory.create(inp);
        //锟矫碉拷锟斤拷一页 sheet
        //页Sheet锟角达拷0锟斤拷始锟斤拷锟斤拷锟斤拷
        Sheet sheet = wb.getSheetAt(0);
        System.out.println(sheet.getRow(9).getCell(4));
        //锟斤拷锟斤拷foreach循锟斤拷 锟斤拷锟斤拷sheet锟叫碉拷锟斤拷锟斤拷锟斤拷
       /* for (Row row : sheet) {
            //锟斤拷锟斤拷row锟叫碉拷锟斤拷锟叫凤拷锟斤拷
            for (Cell cell : row) {
                //锟斤拷锟斤拷锟斤拷锟斤拷械锟斤拷锟斤拷荩锟斤拷钥崭锟斤拷锟?
                System.out.print(cell.toString() + "  ");
            }
            //每一锟斤拷锟斤拷锟斤拷锟街拷锟斤拷锟?
            System.out.println();
        }*/
        //锟截憋拷锟斤拷锟斤拷锟斤拷
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
