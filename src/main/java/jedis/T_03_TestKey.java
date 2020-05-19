package jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class T_03_TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("清空数据:"+jedis.flushDB());
        System.out.println("判断某个数值是否存在:"+jedis.exists("key01"));
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        System.out.println("增加某个键:"+jedis.set("key01","value01"));
        System.out.println("增加某个键:"+jedis.set("username","xuehy"));
        System.out.println("***删除某个键***:"+jedis.del("key01"));
        System.out.println("查看username的存储类型:"+jedis.type("xuehy"));
        System.out.println("随机返回一个key:"+jedis.randomKey());
        System.out.println("重命名key:"+jedis.rename("username","name"));
        System.out.println("返回当前数据库中key的数目:"+jedis.dbSize());
    }
}
