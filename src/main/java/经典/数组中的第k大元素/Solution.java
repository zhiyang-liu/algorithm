package 经典.数组中的第k大元素;

/**
 * Created by liuzhiyang on 2020/7/13 下午4:16
 */
public class Solution {

    /**
     * 堆排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = nums.length / 2; i >= 0; i--)
            heapMinAdj(nums, i, n);
        //删除最大值
        for (int j = nums.length - 1; j >= k; j--) {
            //最后一个值放到根的位置
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            heapMinAdj(nums, 0, --n);
        }
        return nums[0];
    }

    public static void heapMinAdj(int[] array, int pos, int n) {
        while (true) {
            int child = pos * 2 + 1;
            if (child >= n) break;
            if ((child + 1 < n) && (array[child] > array[child + 1]))
                child ++;
            if (array[pos] > array[child]) {
                int temp = array[pos];
                array[pos] = array[child];
                array[child] = temp;
                heapMinAdj(array, child, n);
            } else
                break;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(res);
    }

}
