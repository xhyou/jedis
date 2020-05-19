package jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class T_08_TestZset {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        Map<String,Double> map = new HashMap();
        map.put("xh",2700.0);
        map.put("xl",2800.0);
        map.put("xz",2400.0);
        map.put("xf",3000.0);
        jedis.zadd("zset",map);
        System.out.println(jedis.zadd("zset",2600,"xm"));
        System.out.println(jedis.zrange("zset",0,-1));
        System.out.println(jedis.zrangeWithScores("zset",0,-1));
        System.out.println("移除操作:"+jedis.zrem("zset","xm"));
        System.out.println(jedis.zrangeWithScores("zset",0,-1));
        System.out.println("获取个数:"+jedis.zcard("zset"));
        System.out.println("获取指定区间的值:"+jedis.zrange("zset",0,2));
        System.out.println(jedis.keys("*"));
    }
}
