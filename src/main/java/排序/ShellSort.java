package 排序;

import java.util.Arrays;

/**
 * 希尔排序-缩小增量的插入排序（插入类）
 * Created by liuzhiyang on 2020/11/17 下午5:16
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        // 计算出最大的h值
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("h=" + h);
            for (int i = h; i < arr.length; i++) {
                if (arr[i] < arr[i - h]) {
                    int tmp = arr[i];
                    int j = i - h;
                    while (j >= 0 && arr[j] > tmp) {
                        arr[j + h] = arr[j];
                        j -= h;
                    }
                    arr[j + h] = tmp;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(Arrays.toString(arr));
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }

}
