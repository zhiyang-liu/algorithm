package 经典.不同的二叉搜索树;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuzhiyang on 2020/7/9 下午9:11
 */
public class Solution {

    public LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
        allTrees.pollLast();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> leftTrees = generateTrees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> rightTrees = generateTrees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public static void main(String[] args) {
        new Solution().generateTrees(3);
    }

}
