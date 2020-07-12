package 经典.有序数组构造二叉搜索树;

import 经典.不同的二叉搜索树.TreeNode;

/**
 * Created by liuzhiyang on 2020/7/10 下午8:30
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
        if (sIdx > eIdx) return null;
        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);
        root.left =  toBST(nums, sIdx, mIdx - 1);
        root.right = toBST(nums, mIdx + 1, eIdx);
        return root;
    }

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{1, 2, 3, 4});
    }

}
