package 负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 加权随机算法
 * Created by liuzhiyang on 2020/10/26 下午4:23
 */
public class WeightRandomTest {

    private static Map<String, Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1", 1);
        ipMap.put("192.168.13.2", 2);
        ipMap.put("192.168.13.3", 4);
    }

    public String weightRandom() {
        Map<String, Integer> ipServerMap = new HashMap<>();
        ipServerMap.putAll(ipMap);

        Set<String> ipSet = ipServerMap.keySet();

        ArrayList<String> ips = new ArrayList<>();

        // 给list中添加对应数字的server数量
        Iterator<String> ipIterator = ipSet.iterator();
        while (ipIterator.hasNext()) {
            String serverName = ipIterator.next();
            Integer weight = ipServerMap.get(serverName);
            for (int i = 0; i < weight; i++) {
                ips.add(serverName);
            }
        }

        Random random = new Random();
        int pos = random.nextInt(ips.size());
        return ips.get(pos);
    }

    public static void main(String[] args) {
        WeightRandomTest testWeightRandom = new WeightRandomTest();
        for (int i = 0; i < 10; i++) {
            String server = testWeightRandom.weightRandom();
            System.out.println(server);
        }
    }

}
