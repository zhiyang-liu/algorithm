package 负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 随机算法
 * Created by liuzhiyang on 2020/10/26 下午4:09
 */
public class RandomTest {

    private static Map<String,Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1", 1);
        ipMap.put("192.168.13.2", 2);
        ipMap.put("192.168.13.3", 4);
    }

    public String random() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String,Integer> ipServerMap = new HashMap<>();
        ipServerMap.putAll(ipMap);

        // 取得ip地址List
        ArrayList<String> ips = new ArrayList<>();
        ips.addAll(ipServerMap.keySet());

        // 循环随机数
        Random random = new Random();
        int pos = random.nextInt(ips.size());

        return ips.get(pos);
    }

    public static void main(String[] args) {
        RandomTest testRandom = new RandomTest();
        for (int i = 0; i < 10; i++) {
            String server = testRandom.random();
            System.out.println(server);
        }
    }

}
