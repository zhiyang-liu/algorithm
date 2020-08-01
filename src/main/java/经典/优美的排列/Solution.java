package 经典.优美的排列;

import java.util.Arrays;

/**
 * 667 优美的排列2
 * Created by liuzhiyang on 2020/7/23 下午3:24
 */
public class Solution {

    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] res = new Solution().constructArray(10, 2);
        System.out.println(Arrays.toString(res));
    }

}
