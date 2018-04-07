package test;
import com.jacob.com.Variant;
import com.jacob.com.InvocationProxy;
/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/11/5.
 * Time:23:10.
 */
public class ListenEvent extends InvocationProxy {

    public void OnFinger(Variant[] arge) {
        System.out.println("当机器上指纹头上检测到有指纹时触发该消息，无返回值");
    }
    public void OnVerify(Variant[] arge) {
        System.out.println("当机器上指纹头上检测到有指纹时触发该消息，无返回值"+arge.toString());
    }

    public void OnConnected(){
        System.out.println("OnConnected");
    }

    public void OnDisConnected(){
        System.out.println("OnDisConnected");
    }

    @Override
    public Variant invoke(String var1, Variant[] var2){
        Variant variant = new Variant();
        System.out.print("sdsdfdfsd立即送福利");
        return variant;
    }
}
