package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

public class T_05_TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        System.out.println("===========添加一个list===========");
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("collections的值:"+jedis.lrange("collections",0,-1));
        System.out.println("出栈:"+jedis.lpop("collections"));
        System.out.println("获取长度:"+jedis.llen("collections"));
        System.out.println("获取指定位置的值:"+jedis.lindex("collections",0));
        System.out.println("移除指定个数:"+jedis.lrem("collections",2,"HashMap"));
        System.out.println("collections的值:"+jedis.lrange("collections",0,-1));
        System.out.println("截取操作:"+jedis.ltrim("collections",0,2));
        System.out.println("collections的值:"+jedis.lrange("collections",0,-1));
        System.out.println("移除表中的尾部元素插入到新表:"+jedis.rpoplpush("collections","collections1"));
        System.out.println("collections1的值:"+jedis.lrange("collections1",0,-1));
        System.out.println("替换操作:"+jedis.lset("collections1",0,"Nice"));
        System.out.println("collections1的值:"+jedis.lrange("collections1",0,-1));
        System.out.println(jedis.linsert("collections1", ListPosition.BEFORE,"Nice","Good"));
        System.out.println("collections1的值:"+jedis.lrange("collections1",0,-1));
        jedis.flushDB();
        System.out.println("===排序===");
        jedis.lpush("sortedList", "3","6","2","0","7","4");
        System.out.println("sortedList排序前："+jedis.lrange("sortedList", 0, -1));
        System.out.println("sortedList排序后："+jedis.sort("sortedList"));
    }
}
