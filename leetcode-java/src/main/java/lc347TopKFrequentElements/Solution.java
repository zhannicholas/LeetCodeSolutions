package lc347TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

1 <= nums.length <= 10^5
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的


进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Solution {
    /**
     * 先统计各个数字的出现频率，然后使用优先队列筛选出结果
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 先统计每个数字的出现频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            Integer frequency = frequencyMap.get(num);
            if (frequency == null) {
                frequencyMap.put(num, 1);
            } else {
                frequencyMap.put(num, frequency + 1);
            }
        }

        // 频率低的优先级更高，这样当队列容量达到 k 时，出队的元素就是频率最低的
        Queue<NumFrequency> queue = new PriorityQueue<>((o1, o2) -> o2.frequency - o1.frequency);
        int k1 = k;
        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            queue.offer(new NumFrequency(entry.getKey(), entry.getValue()));
            if (k1 > 0) {
                k1--;
            } else {
                if (entry.getValue() > queue.peek().frequency) {
                    queue.poll();
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().num;
        }
        return ans;
    }
}

class NumFrequency {
    int num;
    int frequency;

    public NumFrequency(int num, int frequency) {
        this.num = num;
        this.frequency = frequency;
    }
}
