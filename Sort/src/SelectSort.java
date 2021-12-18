import java.util.Arrays;

public class SelectSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }


    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 9, 3, 1, 7, 43, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
