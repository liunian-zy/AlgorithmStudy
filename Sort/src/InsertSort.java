import java.util.Arrays;

public class InsertSort {


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] > arr[j - 1]; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 9, 3, 1, 7, 43, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
