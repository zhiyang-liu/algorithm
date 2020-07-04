package 经典.背包;

/**
 * 01背包问题
 * Created by liuzhiyang on 2020/6/15 下午3:34
 */
public class Bag1 {

    /**
     * 递归
     */
    int[] vs = {0,2,4,3,7};
    int[] ws = {0,2,3,5,5};

    public void testKnapsack1() {
        int result = ks(4,10);
        System.out.println(result);
    }

    private int ks(int i, int c) {
        int result = 0;
        if (i == 0 || c == 0) {
            // 初始条件
            result = 0;
        } else if (ws[i] > c) {
            // 装不下该珠宝
            result = ks(i - 1, c);
        } else {
            // 可以装下
            int tmp1 = ks(i - 1, c);
            int tmp2 = ks(i - 1, c - ws[i]) + vs[i];
            result = Math.max(tmp1, tmp2);
        }
        return result;
    }

    // W 为背包总体积
    // N 为物品数量
    // weights 数组存储 N 个物品的重量
    // values 数组存储 N 个物品的价值
    public int knapsack1(int W, int N, int[] weights, int[] values) {
        //  dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 空间优化
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 8;
        int N = 4;
        int[] weights = {5, 3, 4, 2};
        int[] values = {3, 4, 5, 6};

        int res = new Bag1().knapsack1(W, N, weights, values);

        System.out.println(res);
    }

}
