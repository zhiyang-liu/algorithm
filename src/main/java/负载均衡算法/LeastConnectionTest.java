package 负载均衡算法;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 最小连接数算法
 * Created by liuzhiyang on 2020/10/26 下午4:48
 */
public class LeastConnectionTest {

    // 需要修改Map可以用ConcurrentHashMap保证线程安全
    private static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    // 模拟请求的次数
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    static {
        ipMap.put("192.168.13.1", random.nextInt(10));
        ipMap.put("192.168.13.2", random.nextInt(10));
        ipMap.put("192.168.13.3", random.nextInt(10));
    }

    // 从list中选取接受请求数最少的服务并返回
    public String leastConnection() {
        // 不能重建Map，需要修改连接次数
        Iterator<String> ipsIterator = ipMap.keySet().iterator();

        String serverName = null;
        int times = 0;

        while (ipsIterator.hasNext()) {
            String tmpServerName = ipsIterator.next();
            int requestTimes = ipMap.get(tmpServerName);

            if (times == 0) {
                serverName = tmpServerName;
                times = requestTimes;
            } else {
                if (times > requestTimes) {
                    serverName = tmpServerName;
                    times = requestTimes;
                }
            }
        }

        ipMap.put(serverName, ++times);//访问后+1
        System.out.println("获取到的地址是：" + serverName + ", 访问次数：" + times);

        return serverName;
    }

    public static void main(String[] args) {
        LeastConnectionTest testLeastConnection = new LeastConnectionTest();
        for (int i = 0; i < 10; i++) {
            testLeastConnection.leastConnection();
        }
    }

}
