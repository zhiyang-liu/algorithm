package 排序;

import java.util.Arrays;

/**
 * 归并排序
 */
public class InverseSort {

    public static void inversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) >> 1;
        inversePairsCore(array, copy, low, mid);
        inversePairsCore(array, copy, mid + 1, high);
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                copy[locCopy--] = array[i--];
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,6,2,2,5};
        int[] temp = new int[5];
        inversePairsCore(arr, temp, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

}
