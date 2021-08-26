package lc881BoatsToSavePeople;

import java.util.Arrays;

/*
881. 救生艇
第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

返回载到每一个人所需的最小船数。(保证每个人都能被船载)。



示例 1：

输入：people = [1,2], limit = 3
输出：1
解释：1 艘船载 (1, 2)
示例 2：

输入：people = [3,2,2,1], limit = 3
输出：3
解释：3 艘船分别载 (1, 2), (2) 和 (3)
示例 3：

输入：people = [3,5,3,4], limit = 5
输出：4
解释：4 艘船分别载 (3), (3), (4), (5)
提示：

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
 */
public class Solution {
    /**
     * 贪心策略：让每条船尽可能多的装人
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);    // 升序排列
        int left = 0, right = people.length - 1, boats = 0;
        while (left <= right) {
            int available = limit;
            int leftSeats = 2;  // 每条船最多可载两人
            // 先尽可能地的装最重的
            while (leftSeats > 0 && left <= right && available - people[right] >= 0) {
                available -= people[right--];
                leftSeats--;
            }
            // 再尽可能多地装最轻的
            while (leftSeats > 0 && left <= right && available - people[left] >= 0) {
                available -= people[left++];
                leftSeats--;
            }
            boats++;
        }

        return boats;
    }
}
