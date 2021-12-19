public class XOR {

    // 一个数组中有一个数出现了奇数次，其余数都出现了偶数次，找到这个出现奇数次的数
    public static int findOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int j : arr) {
            eor ^= j;
        }
        return eor;
    }

    // 提取一个int类型的数最右侧的1
    public static int right1Num(int n) {
        n &= (-n);
        return n;
    }

    // 一个数组中有两种数出现了奇数次，其余数都出现了偶数次，找到这两种出现奇数次的数
    public static void findOddTimesNum2(int[] arr) {
        int eor = 0;
        int eor2 = 0;
        for (int j : arr) {
            eor ^= j;
        }
        int rightOne = eor & (-eor);
        for (int j : arr) {
            if ((j & rightOne) != 0) {
                eor2 ^= j;
            }
        }
        System.out.println("eor:" + eor + ",eor2:" + eor2);
    }

    // 一个数组中有一种数出现K次，其他数都出现了M次，M > 1, K < M。找到出现了K次的数，要求，额外空间复杂度O(1)，时间复杂度O(N)
    public static int KM(int[] arr, int k, int m) {
        int ans = 0;
        int[] t = new int[32];
        for (int j : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (j >> i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                ans |= 1 << i;
            } else {
                return -1;
            }
        }
        return ans;
    }

    // 上题简单改一下需求，要求存在这样的出现了K次的数就返回，否则返回-1
    public static int KM2(int[] arr, int k, int m) {
        int ans = 0;
        int[] t = new int[32];
        for (int j : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (j >> i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                ans |= 1 << i;
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int j : arr) {
                if (j == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }

    // 对数器

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int[] arr1 = new int[]{0, 0, 0, 0, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        System.out.println(KM(arr, 2, 3));
        System.out.println(KM2(arr1, 2, 3));
    }
}
