# 选择排序

从左向右，每个数都和右边剩余的数比较，选出最小的与其交换位置

0~n,左边界每次加一

时间复杂度 O(n^2)

代码实现(java)

```java
public static void sort(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }
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
```

