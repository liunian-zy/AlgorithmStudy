import java.util.Arrays;

public class BinarySearch {


    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            }
            if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static int nearestLeftIndex(int[] sortedArr, int value) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int nearestRightIndex(int[] sortedArr, int value) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int L = 1;
        int R = arr.length - 2;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] > arr[mid]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 9, 3, 1, 7, 43, 5, 2, 6};
        int[] unSortedArr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        boolean exist = exist(arr, 5);
        System.out.println("数组中是否存在给定的数：" + exist);
        int leftIndex = nearestLeftIndex(arr, 7);
        int rightIndex = nearestRightIndex(arr, 7);
        System.out.println("数组中>=给定数的最左侧位置是:" + leftIndex);
        System.out.println("数组中<=给定数的最右侧位置是:" + rightIndex);
        int lessIndex = getLessIndex(unSortedArr);
        System.out.println(Arrays.toString(unSortedArr));
        System.out.println("数组中局部最小值的位置坐标是:" + lessIndex);
    }
}
