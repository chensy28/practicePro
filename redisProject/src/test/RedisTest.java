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

        //切换数据库
        /*jedis.select(3);
        jedis.set("three","threes");*/
        //System.out.print(jedis.get("three"));

        //jedis.set("age","5");
        //自减
        //jedis.decr("age");
       // System.out.print(a);

        //获取什么配置内容的？
       /* List<String> strList = jedis.configGet("age");
        for(String str : strList){
            System.out.print(str);
        }*/

        //取指定范围字符串
        //System.out.print(jedis.getrange("csy", 0, 3));
        System.out.print(jedis.ping());

    }
}
