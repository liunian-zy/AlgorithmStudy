# 求数组小和

在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。 例子： [1,3,4,2,5]
1左边比1小的数：没有 3左边比3小的数：1 4左边比4小的数：1、3 2左边比2小的数：1 5左边比5小的数：1、3、4、 2 所以数组的小和为1+1+3+1+1+3+4+2=16

利用归并排序在merge的过程中有比较的特性即可。将寻找比一个数左边小改为寻找所有右边比他大是解题关键。注意相等时可以当做小于看待，即相等拷贝右边数据，这也是与标准归并排序唯一的区别（函数返回值类型不算）。

代码实现：

```java
public static int smallSum(int[] arr) {
    if (arr == null || arr.length < 2) {
        return 0;
    }
    return process(arr, 0, arr.length - 1);
}

// arr[L..R]既要排好序，也要求小和返回
// 所有merge时，产生的小和，累加
// 左 排序   merge
// 右 排序  merge
// merge
public static int process(int[] arr, int l, int r) {
    if (l == r) {
        return 0;
    }
    // l < r
    int mid = l + ((r - l) >> 1);
    return
        process(arr, l, mid)
        +
        process(arr, mid + 1, r)
        +
        merge(arr, l, mid, r);
}

public static int merge(int[] arr, int L, int m, int r) {
    int[] help = new int[r - L + 1];
    int i = 0;
    int p1 = L;
    int p2 = m + 1;
    int res = 0;
    while (p1 <= m && p2 <= r) {
        res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
        help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
    }
    while (p1 <= m) {
        help[i++] = arr[p1++];
    }
    while (p2 <= r) {
        help[i++] = arr[p2++];
    }
    for (i = 0; i < help.length; i++) {
        arr[L + i] = help[i];
    }
    return res;
}
```



