# 冒泡排序

从左向右，相邻两个位置的数谁大谁往右

0~n-1,右边界每次减一

时间复杂度 O(n^2)

代码实现(java)

```java
public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }
}
```

