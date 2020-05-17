package 经典;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 矩阵左上角到右下角最短距离
 *  BFS思想
 * Created by liuzhiyang on 2020/5/17 下午3:21
 */
public class MatrixPath {

    public static int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, -1}, {1, 0}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}};

        System.out.println(shortestPathBinaryMatrix(matrix));
    }

}
