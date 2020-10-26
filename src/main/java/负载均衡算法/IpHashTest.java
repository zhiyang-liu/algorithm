package 负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ip-hash算法
 * Created by liuzhiyang on 2020/10/26 下午4:41
 */
public class IpHashTest {

    private static Map<String, Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1", 1);
        ipMap.put("192.168.13.2", 2);
        ipMap.put("192.168.13.3", 4);
    }

    public String ipHash(String clientIP) {
        Map<String, Integer> ipServerMap = new HashMap<>();
        ipServerMap.putAll(ipMap);

        Set<String> ipset = ipServerMap.keySet();

        ArrayList<String> ips = new ArrayList<>();
        ips.addAll(ipset);

        int hashCode = clientIP.hashCode();
        int serverIpsize = ips.size();
        int pos = hashCode % serverIpsize;
        return ips.get(pos);
    }

    public static void main(String[] args) {
        IpHashTest testIpHash = new IpHashTest();
        for (int i = 0; i < 10; i++) {
            System.out.println(testIpHash.ipHash("192.168.21.2"));
            System.out.println(testIpHash.ipHash("192.168.21.3"));
        }
    }

}
