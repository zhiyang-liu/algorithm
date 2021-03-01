package 经典;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by liuzhiyang on 2021/2/28 下午5:04
 */
public class DeleteDuplicates {

    public int[] deleteDuplicates(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != list.peekLast()) {
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,5,5,3,4,6,6,7,4};
        int[] newNums = new DeleteDuplicates().deleteDuplicates(nums);
        System.out.println(Arrays.toString(newNums));

    }

}
