package com.csy.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年02月23日 下午08:18
 *
 * @author csypc
 * @version 1.0
 */
public class EngineTest {

    public static void main(String[] args) throws Exception{
        //引擎管理类
        ScriptEngineManager sem = new ScriptEngineManager();
        //引擎
        ScriptEngine engine = sem.getEngineByName("javascript");//可以写为js

        //放入到引擎状态中
        engine.put("msg","aaa");
        System.out.println(engine.get("msg"));

        //输出js中变量的值
        String str = "var user ={name:'张三',age:18};";
        str += "print(user.age)";
        engine.eval(str);
        //engine.eval("print('Hello, World')");

        //调用js中的方法
        engine.eval("function add(a,b){var sum = a+b;return sum;}");

        Invocable jsinvocable = (Invocable)engine;
        //用于调用脚本中定义的顶层程序和函数。
        Object result = jsinvocable.invokeFunction("add",new Object[]{13,52});
        System.out.println(result);

        //导入其它的java包，使用包中的java类
        //ReferenceError: "importPackage" is not defined in <eval> at line number 1
        String jsCode= "importPackage(java.util); var list = Arrays.asList(['gg','hh','kk']);";
        engine.eval(jsCode);

        List<String> list = (List<String>)engine.get("list");
        for(String s : list){
            System.out.println(s);
        }
    }

}
