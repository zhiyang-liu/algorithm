package 排序;

import java.util.Arrays;

/**
 * 直接选择排序（选择类）
 */
public class SelectSort {

    public static void selectSort(int[] a) {
        int min, temp;
        int n = a.length;
        for (int i = 0; i < n - 1; ++i) {
            min = i;
            for (int j = i + 1; j < n; ++j)
                if (a[j] < a[min])
                    min = j;
            if (i != min) {
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] a = new int[] {3, 9, 7, 1};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
