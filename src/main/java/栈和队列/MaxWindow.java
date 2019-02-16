package 栈和队列;

import java.util.LinkedList;

/**
 * 输入：整型数组arr，窗口大小为w
 * 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
 */
public class MaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int [arr.length - w + 1];//共n-w+1个结果值
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {//双端队列队尾索引对应的元素小于等于当前元素，
                // 就移除队尾索引指导队尾元素大于当前元素，才放入当前元素
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == (i - w)) { //如果双端队列开头的索引已经过期，就移除
                qmax.pollFirst();
            }
            if (i >= w-1) {//从w-1索引开始，统计结果值，双端队列开头元素就是最大值
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 4, 5, 6};
        int[] res = new MaxWindow().getMaxWindow(test, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
