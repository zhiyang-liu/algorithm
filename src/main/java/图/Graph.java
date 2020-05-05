package 图;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzhiyang on 2020/5/5 下午9:50
 */
public class Graph {

    // 邻接矩阵
    public Map<Integer, List<Integer>> edges = new HashMap<>();

    /**
     * 初始化图数据：使用邻居表来表示图数据。
     */
    public void initGraphData() {
//        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
        edges.put(1, Arrays.asList(2, 3));
        edges.put(2, Arrays.asList(1, 4, 5));
        edges.put(3, Arrays.asList(1, 6, 7));
        edges.put(4, Arrays.asList(2, 8));
        edges.put(5, Arrays.asList(2, 8));
        edges.put(6, Arrays.asList(3, 8, 9));
        edges.put(7, Arrays.asList(3, 9));
        edges.put(8, Arrays.asList(4, 5, 6));
        edges.put(9, Arrays.asList(6, 7));
    }

}
