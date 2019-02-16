package 栈和队列;

import java.util.HashMap;
import java.util.Stack;

/**
 * 一个数组的MaxTree定义如下：
 * 数组必须没有重复元素
 * MaxTree是一棵二叉树，数组的每个值对应二叉树的一个节点
 * 包括MaxTree在内且在其中每一棵子树上，值最大的节点都是树的头
 */
public class MaxTree {

    //二叉树节点
    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 建树原则：
     * 每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的数中，较小的一个。
     * 如果一个数左边没有比它大的数，右边也没有。那么这个数就是MaxTree的头。
     */

    public Node getMaxTree(int arr[]) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();//报错可能是模型的支持最新java的问题，点击工程结构将language level设置为8即可
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        /**
         * 找每个数左边第一个比它大的数，从左到右便利每个数，栈中保持递减序列，新来的数不停的利用pop出栈顶
         * （每一次pop出的数的下一个栈顶的数就是pop出的数的左侧第一个比它大的数，存入hashMap即可），
         * 直到栈顶比新数大或没有数。
         */
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {//最后剩的的递减序列，再pop，并取其下一个数就是左边第一个比它大的数。
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i <= nArr.length -1; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    /**
     * 每一次pop的数也就得到了比它大的第一个数（左或右）
     */
    public void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        MaxTree maxTree = new MaxTree();
        Node head = maxTree.getMaxTree(arr);
        System.out.println(head.right.value);
    }

}
