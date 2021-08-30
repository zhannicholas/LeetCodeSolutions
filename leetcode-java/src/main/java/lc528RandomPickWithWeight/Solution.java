package lc528RandomPickWithWeight;

import java.util.Random;

/**
 * 前缀和 + 二分搜索
 */
public class Solution {
    private final int[] prefixSum;

    public Solution(int[] w) {
        // 计算前缀和
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int val = (int)(Math.random() * prefixSum[prefixSum.length - 1]) + 1;
        return binarySearch(prefixSum, val);
    }

    private int binarySearch(int[] arr, int val) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] < val) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
