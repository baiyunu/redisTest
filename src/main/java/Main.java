import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        for (int i=0;i<arrayList.size();i++){
            jedis.zadd("myzset",i ,arrayList.get(i));

        }
        Set<String> myzset = jedis.zrange("myzset", 0, -1);
        System.out.println(myzset.toString());
        Set<String> myzset1 = jedis.zrevrangeByScore("myzset", 1, 5, 1, 5);
        System.out.println(myzset1.toString());


    }
}
