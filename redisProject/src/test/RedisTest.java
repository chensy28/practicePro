package test;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by csypc on 2015/10/26.
 */
public class RedisTest {
    public static void main(String []args){

        Jedis jedis = new Jedis("localhost");
        //jedis.set("foo", "bar");
        //String value = jedis.get("foo");
        //jedis.hset("h:001","name","sd");
       // Long a =jedis.del("foo");

        //�л����ݿ�
        /*jedis.select(3);
        jedis.set("three","threes");*/
        //System.out.print(jedis.get("three"));

        //jedis.set("age","5");
        //�Լ�
        //jedis.decr("age");
       // System.out.print(a);

        //��ȡʲô�������ݵģ�
       /* List<String> strList = jedis.configGet("age");
        for(String str : strList){
            System.out.print(str);
        }*/

        //ȡָ����Χ�ַ���
        //System.out.print(jedis.getrange("csy", 0, 3));
        System.out.print(jedis.ping());

    }
}
