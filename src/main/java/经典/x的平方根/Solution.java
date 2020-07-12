package 经典.x的平方根;

/**
 * Created by liuzhiyang on 2020/7/6 下午7:00
 */
class Solution {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1, h = x;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return h;
    }

    public static void main(String[] args) {
        new Solution().mySqrt(7);
    }

}
