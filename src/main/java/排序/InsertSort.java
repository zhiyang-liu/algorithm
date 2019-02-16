package 排序;

import java.util.Arrays;

/**
 * 直接插入排序（插入类）
 */
public class InsertSort {

    public static void insertSort(int a[]) {
        int n = a.length;
        int i, j;
        int temp;
        for (i = 1; i < n; ++i) {
            if (a[i] < a[i - 1]) {
                temp = a[i];
                for (j = i - 1; j >= 0 && a[j] > temp; --j)
                    a[j + 1] = a[j];
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,6,2,2,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
