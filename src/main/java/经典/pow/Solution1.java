package 经典.pow;

/**
 * Created by liuzhiyang on 2020/7/4 下午9:09
 */
public class Solution1 {

    /**
     * 递归
     * @param x
     * @param N
     * @return
     */
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double half = quickMul(x, N / 2);
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static void main(String[] args) {
        new Solution1().myPow(2, 5);
    }

}
