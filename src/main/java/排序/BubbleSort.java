package 排序;

import java.util.Arrays;

/**
 * 冒泡排序（交换类）
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int temp;
        boolean flag;
        for (int i = 0; i < a.length - 1; i++) {
            flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    flag = true;
                }
            }
            if (flag == false)
                return;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 6, 2, 2, 5};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
