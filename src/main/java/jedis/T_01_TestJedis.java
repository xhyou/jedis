package jedis;

import redis.clients.jedis.Jedis;

public class T_01_TestJedis {
    //测试jedis
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());//打印pong说明连接成功
    }
}
