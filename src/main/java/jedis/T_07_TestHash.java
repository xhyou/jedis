package jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class T_07_TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        jedis.hmset("hash",map);
        System.out.println(jedis.hgetAll("hash"));
        jedis.hset("hash","key5","value5");
        System.out.println("删除指定的key:"+jedis.hdel("hash","key1"));
        System.out.println("获取长度:"+jedis.hlen("hash"));
        System.out.println("是否存在:"+jedis.exists("hash","key1"));
        System.out.println("获取所有的key的值:"+jedis.hkeys("hash"));
        System.out.println("获取所有的value的值:"+jedis.hkeys("hash"));
        System.out.println("获取指定的值:"+jedis.hget("hash","key1"));
    }
}
