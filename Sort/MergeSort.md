# 归并排序

先让左半部分有序，再让右半部分有序，最后想办法将两部分merge成整体有序。

* 使用递归依次merge
* 使用迭代进行merge

#### 使用递归

base case是只有一个数，然后将左右两组数merge。

代码实现：

```java
// 递归方法实现
public static void mergeSort1(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }
    process(arr, 0, arr.length - 1);
}

// 请把arr[L..R]排有序
// l...r N
// T(N) = 2 * T(N / 2) + O(N)
// O(N * logN)
public static void process(int[] arr, int L, int R) {
    if (L == R) { // base case
        return;
    }
    int mid = L + ((R - L) >> 1);
    process(arr, L, mid);
    process(arr, mid + 1, R);
    merge(arr, L, mid, R);
}

public static void merge(int[] arr, int L, int M, int R) {
    int[] help = new int[R - L + 1];
    int i = 0;
    int p1 = L;
    int p2 = M + 1;
    while (p1 <= M && p2 <= R) {
        help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
    }
    // 要么p1越界了，要么p2越界了
    while (p1 <= M) {
        help[i++] = arr[p1++];
    }
    while (p2 <= R) {
        help[i++] = arr[p2++];
    }
    for (i = 0; i < help.length; i++) {
        arr[L + i] = help[i];
    }
}
```

#### 使用迭代

定义一个变量用来表示步长，根据步长来merge所有符合要求范围的数，最后步长乘2。相当于手动将数组切分成以步长为单位长度，每次merge两个单位长度，不够两个或不够一个单位长度就跳过。

代码实现：

```java
// 非递归方法实现
public static void mergeSort2(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }
    int N = arr.length;
    // 步长
    int mergeSize = 1;
    while (mergeSize < N) { // log N
        // 当前左组的，第一个位置
        int L = 0;
        while (L < N) {
            if (mergeSize >= N - L) {
                break;
            }
            int M = L + mergeSize - 1;
            int R = M + Math.min(mergeSize, N - M - 1);
            merge(arr, L, M, R);
            L = R + 1;
        }
        // 防止溢出
        if (mergeSize > N / 2) {
            break;
        }
        mergeSize <<= 1;
    }
}
```

