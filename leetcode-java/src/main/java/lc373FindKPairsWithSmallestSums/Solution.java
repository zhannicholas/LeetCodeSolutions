package lc373FindKPairsWithSmallestSums;

import java.util.*;

/*
373. 查找和最小的K对数字
给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。

请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。



示例 1:

输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
示例 2:

输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
示例 3:

输入: nums1 = [1,2], nums2 = [3], k = 3
输出: [1,3],[2,3]
解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]


提示:

1 <= nums1.length, nums2.length <= 10^4
-109 <= nums1[i], nums2[i] <= 10^9
nums1, nums2 均为升序排列
1 <= k <= 1000
 */
public class Solution {
    /**
     * 使用优先队列
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 把和最大的放在队头
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.x + p2.y - p1.x - p1.y;
            }
        });
        int k1 = k;
        // 枚举所有会超时，用 k 限制枚举量
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
                if (k1 > 0) {
                    k1--;
                } else {
                    queue.poll();
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            ans.add(Arrays.asList(pair.x, pair.y));
        }
        return ans;
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


