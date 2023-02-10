package 经典;

/**
 * @author liuzhiyang<liuzhiyang @ kuaishou.com>
 * Created on 2023/2/10
 */
public class BinarySearch {

    public int findNumberIndex(int[] arr, int value) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findNumberIndex(int[] arr, int value, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        }
        if (low >= high) {
            return -1;
        } else if (arr[mid] > value) {
            return findNumberIndex(arr, value, low, mid - 1);
        } else {
            return findNumberIndex(arr, value, mid  + 1, high);
        }
    }

}
