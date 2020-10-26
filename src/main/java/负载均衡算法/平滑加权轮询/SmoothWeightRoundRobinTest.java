package 负载均衡算法.平滑加权轮询;

import java.util.ArrayList;
import java.util.List;

/**
 * 平滑加权轮询
 * Created by liuzhiyang on 2020/10/26 下午5:34
 */
public class SmoothWeightRoundRobinTest {

    private static List<ServerInfo> serverInfos = new ArrayList<>();

    static {
        serverInfos.add(new ServerInfo("192.168.13.1", 1, 0));
        serverInfos.add(new ServerInfo("192.168.13.2", 2, 0));
        serverInfos.add(new ServerInfo("192.168.13.3", 4, 0));
    }

    public String weightRoundRobin() {
        int total = 0;

        ServerInfo bestServerInfo = serverInfos.get(0);
        for (ServerInfo serverInfo : serverInfos) {
            // 计算总和
            total += serverInfo.getWeight();
            // 每个节点，用它们的当前值加上它们自己的权重
            serverInfo.setCurrent(serverInfo.getCurrent() + serverInfo.getWeight());
            // 选择当前值最大的节点为选中节点
            if (serverInfo.getCurrent() > bestServerInfo.getCurrent()) {
                bestServerInfo = serverInfo;
            }
        }

        bestServerInfo.setCurrent(bestServerInfo.getCurrent() - total);

        return bestServerInfo.getIp();
    }

    public static void main(String[] args) {
        SmoothWeightRoundRobinTest smoothWeightRoundRobinTest = new SmoothWeightRoundRobinTest();
        for (int i = 0; i < 35; i++) {
            String server = smoothWeightRoundRobinTest.weightRoundRobin();
            System.out.println(server);
        }
    }

}
