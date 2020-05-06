package 图;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liuzhiyang on 2020/5/5 下午9:14
 */
public class GraphLoopTest {

    /**
     * 广度优先搜索遍历
     * @param graph
     * @param start
     */
    public static void bfs(Graph graph, int start) {
        Map<Integer, List<Integer>> edges = graph.edges;

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[edges.keySet().size() + 1];

        visited[start] = 1;
        System.out.print(start);

        queue.offer(start);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : edges.get(i)) {
                if(visited[j] == 0){
                    System.out.print(j);
                    visited[j] = 1;
                    queue.offer(j);
                }
            }
        }
    }

    /**
     * 深度优先搜索遍历
     * @param graph
     */
    public static void dfs(Graph graph) {
        Map<Integer, List<Integer>> edges = graph.edges;

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[edges.keySet().size() + 1];

        for (int node : edges.keySet()) {
            if (visited[node] == 0) {
                visited[node] =1;
                System.out.print(node);
                stack.push(node);

                while (! stack.isEmpty()) {
                    int i = stack.pop();
                    for (int j : edges.get(i)) {
                        if (visited[j] == 0) {
                            visited[j] = 1;
                            System.out.print(j);
                            stack.push(j);
                            // 这条路结束,返回上一个节点.
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 深度优先搜索遍历（递归）
     * @param graph
     * @param start
     */
    private static int[] visited1 = new int[10];

    public static void dfs1(Graph graph, int start) {
        Map<Integer, List<Integer>> edges = graph.edges;

        if (visited1[start] == 0) {
            dfsTrav1(edges, start);
        }
    }

    static void dfsTrav1(Map<Integer, List<Integer>> edges, int n) {
        visited1[n] = 1;
        System.out.print(n);

        for (int i : edges.get(n)) {
            if (visited1[i] == 0) {
                dfsTrav1(edges, i);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.initGraphData();
        bfs(graph, 3);
        System.out.println();
        dfs(graph);
        System.out.println();
        dfs1(graph, 3);
    }

}
