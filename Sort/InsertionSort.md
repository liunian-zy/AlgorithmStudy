# 插入排序

从左向右，每个数都和左边的数进行比较，如果小则进行交换并继续向左比较直至到头

0~n-1,左边界每次加一

时间复杂度 O(n^2)  注意：用最差情况估计时间复杂度

代码实现(java)

```java
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
```

