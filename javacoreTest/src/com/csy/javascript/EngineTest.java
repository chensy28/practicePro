package com.csy.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��02��23�� ����08:18
 *
 * @author csypc
 * @version 1.0
 */
public class EngineTest {

    public static void main(String[] args) throws Exception{
        //���������
        ScriptEngineManager sem = new ScriptEngineManager();
        //����
        ScriptEngine engine = sem.getEngineByName("javascript");//����дΪjs

        //���뵽����״̬��
        engine.put("msg","aaa");
        System.out.println(engine.get("msg"));

        //���js�б�����ֵ
        String str = "var user ={name:'����',age:18};";
        str += "print(user.age)";
        engine.eval(str);
        //engine.eval("print('Hello, World')");

        //����js�еķ���
        engine.eval("function add(a,b){var sum = a+b;return sum;}");

        Invocable jsinvocable = (Invocable)engine;
        //���ڵ��ýű��ж���Ķ������ͺ�����
        Object result = jsinvocable.invokeFunction("add",new Object[]{13,52});
        System.out.println(result);

        //����������java����ʹ�ð��е�java��
        //ReferenceError: "importPackage" is not defined in <eval> at line number 1
        String jsCode= "importPackage(java.util); var list = Arrays.asList(['gg','hh','kk']);";
        engine.eval(jsCode);

        List<String> list = (List<String>)engine.get("list");
        for(String s : list){
            System.out.println(s);
        }
    }

}
