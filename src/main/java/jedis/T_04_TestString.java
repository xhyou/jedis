package jedis;

import redis.clients.jedis.Jedis;

public class T_04_TestString {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        System.out.println("===增加数据===");
        System.out.println(jedis.set("key1","value1"));//设置基本的数据类型
        System.out.println(jedis.set("key2","value2"));//设置基本的数据类型
        System.out.println(jedis.set("key3","value3"));//设置基本的数据类型
        System.out.println("删除指定的键:"+jedis.del("key1"));//删除指定的键
        System.out.println("获取指定的键:"+jedis.get("key2"));//获取指定的键
        System.out.println("修改指定的键:"+jedis.set("key3","value33"));//修改指定的键
        System.out.println("拼接指定的值:"+jedis.append("key3","hello"));//修改指定的键
        //多个操做
        System.out.println("增加多个键:"+jedis.mset("key01","value01","key02","value02"));
        System.out.println("获取多个值:"+jedis.mget("key01","key02"));
        System.out.println("删除多个键:"+jedis.del("key01","key02"));
        System.out.println("获取多个值:"+jedis.mget("key01","key02"));
        jedis.flushDB();
        //使用setnx 当key不存在时候新增 存在的时候不覆盖
        System.out.println(jedis.setnx("key01","value01"));
        System.out.println(jedis.setnx("key02","value02"));
        System.out.println(jedis.get("key01"));

        System.out.println("===========新增键值对并设置有效时间=============");
        System.out.println(jedis.setex("key03",2,"value03"));
        System.out.println(jedis.get("key03"));
        Thread.sleep(3);
        System.out.println(jedis.get("key03"));
        System.out.println("===========获取原值，更新为新值==========");
        System.out.println(jedis.getSet("key02","value002"));
        System.out.println(jedis.getrange("key02",0,4));
        System.out.println(jedis.keys("*"));
        jedis.flushDB();
        System.out.println("==="+jedis.setrange("key01",0,"li"));
        System.out.println(jedis.get("key01"));
    }
}
