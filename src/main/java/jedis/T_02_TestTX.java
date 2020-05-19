package jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 测试事务
 */
public class T_02_TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        jsonObject.put("age",14);
        String jsonStr = jsonObject.toString();
        //开启事务
        Transaction multi = jedis.multi();
        try {
            multi.set("user1",jsonStr);
            multi.set("user2",jsonStr);
//            int i=1/0; 设置抛出异常
            multi.exec();
        }catch (Exception e ){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
