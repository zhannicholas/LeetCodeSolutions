package lcci1714SmallestK;

import java.util.PriorityQueue;
import java.util.Queue;

/*
面试题 17.14. 最小K个数
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
 */
public class Solution {
    /**
     * 使用容量为 k 的大顶堆
     */
    public int[] smallestK(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n: arr) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();  // 出队最大元素
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
