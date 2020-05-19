package jedis;

import redis.clients.jedis.Jedis;

public class T_06_TestSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        jedis.sadd("set01","e1","e2","e3","e4");
        System.out.println("查询所有的操作:"+jedis.smembers("set01"));
        System.out.println("查询key中的某个元素是否存在:"+jedis.sismember("set01","e1"));
        System.out.println("查看元素的个数:"+jedis.scard("set01"));
        System.out.println("删除指定元素:"+jedis.srem("set01","e1"));
        System.out.println("查询所有的操作:"+jedis.smembers("set01"));
        System.out.println("随机移除集合中的指定个数:"+jedis.spop("set01"));
        System.out.println("查询所有的操作:"+jedis.smembers("set01"));
        System.out.println("移动元素到另外一个Set中:"+jedis.smove("set01","set02","e4"));
        System.out.println("=================================");
        System.out.println(jedis.sadd("eleSet1", "e1","e2","e4","e3","e0","e8","e7","e5"));
        System.out.println(jedis.sadd("eleSet2", "e1","e2","e4","e3","e0","e8"));
        System.out.println("并集:"+jedis.sunion("eleSet1","eleSet2"));
        System.out.println("交集:"+jedis.sinter("eleSet1","eleSet2"));
        System.out.println("差集:"+jedis.sdiff("eleSet1","eleSet2"));
        //取eleSet1,eleSet2的交集放入到eleSet3中
        System.out.println(jedis.sinterstore("eleSet3", "eleSet1", "eleSet2"));
        System.out.println(jedis.smembers("eleSet3"));
    }
}
