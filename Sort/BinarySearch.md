# 二分查找

一、查找一个有序数组中某个数是否存在

0~n-1，当至少有两个数的时候，取中间的数，如果中间的数恰好等于给定的数，则返回真，否则比较中间的数和给定的数，如果中间的数小则代表给定的数可能在右侧，反之可能在左侧。一直循环到只剩1个数，根据这个数是否与给定的数相等进行返回。

时间复杂度：O(logN)

代码实现(java)

```java
public static boolean exist(int[] sortedArr, int num) {
    if (sortedArr == null || sortedArr.length == 0) {
        return false;
    }
    int L = 0;
    int R = sortedArr.length - 1;
    int mid;
    while (L < R) {
        mid = L + ((R - L) >> 2);
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
```

二、查找一个有序数组中>=某个数的最左侧位置

0~n-1，当至少有一个数的时候，取中间的数，如果大于等于给定的数，说明最左侧位置有可能在左侧，反之说明有可能在右侧，直到只剩一个数时，如果这个数大于等于给定的数，则返回这个数的位置，否则返回上一个符合要求的数的位置。

时间复杂度：O(logN)

代码实现

```java
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
```



三、查找一个有序数组中<=某个数最右侧的位置

0~n-1，当至少有一个数的时候，取中间的数，如果小于等于给定的数，说明最右侧位置有可能在右侧，反之说明有可能在左侧，直到只剩一个数时，如果这个数小于等于给定的数，则返回这个数的位置，否则返回上一个符合要求的数的位置。

时间复杂度：O(logN)

代码实现

```java
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
```

四、局部最小值问题

在一个无序数组中，值有可能正，负，或者零，数组中任意两个相邻的数一定不相等。
定义局部最小：
1.长度为1，arr[0]就是局部最小；
2.数组的开头，如果arr[0] < arr[1] ，arr[0]被定义为局部最小。
3.数组的结尾，如果arr[N-1] < arr[N-2] ，arr[N-1]被定义为局部最小。
任何一个中间位置i, 即数组下标1~N-2之间, 必须满足arr[i-1] < arr[i] <arr[i+1] ,叫找到一个局部最小。
请找到任意一个局部最小并返回位置坐标。

时间复杂度：O(logN)

代码实现

```java
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
```

五、总结

二分不一定必须要有序的，不是只有有序才能二分。

一种策略，如果有一边肯定有或者有一边肯定没有，则可以去进行二分操作。
