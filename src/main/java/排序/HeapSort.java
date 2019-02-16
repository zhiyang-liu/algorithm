package 排序;

import java.util.Arrays;

/**
 * 堆排序,大顶堆要求父元素大于左右孩子子树（选择类）
 */
public class HeapSort {

    public static void heapMaxAdj(int[] array, int pos, int n) {
        while (true) {
            int child = pos * 2 + 1;
            if (child >= n) break;
            if ((child + 1 < n) && (array[child] < array[child + 1]))
                child ++;
            if (array[pos] < array[child]) {
                int temp = array[pos];
                array[pos] = array[child];
                array[child] = temp;
                heapMaxAdj(array, child, n);
            } else
                break;
        }
    }

    public static void heapSort(int[] a) {
        int n = a.length;
        int i, temp;
        for (i = n / 2; i >= 0; i--)
            heapMaxAdj(a, i, n);
        for (i = n - 1; i >= 1; --i) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapMaxAdj(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,6,2,2,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
