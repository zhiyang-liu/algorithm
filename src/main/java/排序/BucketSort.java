package 排序;

import java.util.*;

/**
 * 桶排序，（桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中）
 */
public class BucketSort {

    public static ArrayList<ArrayList<Integer>> bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        return bucketArr;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 2, 6, 100, 1};
        ArrayList<ArrayList<Integer>> result = bucketSort(a);
        System.out.println(result);
    }
}
