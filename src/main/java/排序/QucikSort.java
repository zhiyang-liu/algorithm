package 排序;

import java.util.Arrays;

/**
 * 快速排序（交换类）
 */
public class QucikSort {

    /**
     * 方案1
     */
    public static void quickSort1(int[] a, int left, int right) {
        int temp;
        int i = left, j = right;
        if (left < right) {
            temp = a[left];
            while (i != j) {
                while (j > i && a[j] > temp)
                    --j;
                if (i < j) {
                    a[i] = a[j];
                    ++i;
                }
                while (i < j && a[i] < temp)
                    ++i;
                if (i < j) {
                    a[j] = a[i];
                    --j;
                }
            }
            a[i] = temp;
            quickSort1(a, left, i - 1);
            quickSort1(a, i + 1, right);
        }
    }

    /**
     * 方案2, 抽取出partition函数
     */
    public static int partition(int a[], int left, int right) {
        int i = left;
        int j = right;
        int temp = a[i];
        while (i < j) {
            while (i < j && a[j] >= temp)
                j--;
            if (i < j)
                a[i] = a[j];
            while (i < j && a[i] <= temp)
                i++;
            if (i < j)
                a[j] = a[i];
        }
        a[i] = temp;
        return i;
    }

    public static void quickSort2(int[] a,int left,int right) {
        int dp;
        if (left < right) {
            dp = partition(a, left, right);
            quickSort2(a, left, dp - 1);
            quickSort2(a, dp + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 5, 10, 7, 1};
        quickSort1(a, 0, 4);
        System.out.println(Arrays.toString(a));
    }
}
