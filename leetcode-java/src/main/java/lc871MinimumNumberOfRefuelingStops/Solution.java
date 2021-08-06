package lc871MinimumNumberOfRefuelingStops;

import java.util.PriorityQueue;
import java.util.Queue;

/*
871. 最低加油次数
汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。

沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。

假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。

当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。

为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。

注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。



示例 1：

输入：target = 1, startFuel = 1, stations = []
输出：0
解释：我们可以在不加油的情况下到达目的地。
示例 2：

输入：target = 100, startFuel = 1, stations = [[10,100]]
输出：-1
解释：我们无法抵达目的地，甚至无法到达第一个加油站。
示例 3：

输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
输出：2
解释：
我们出发时有 10 升燃料。
我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
我们沿途在1两个加油站停靠，所以返回 2 。


提示：

1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
public class Solution {
    /**
     * 贪心策略：若要加油次数最少，就要在加油站加尽可能多的油，这样才能在跑得更远。
     * 只有一种情况需要加油，就是：当前位置 + 剩余油量 < 下一加油站或目标点的位置
     * 维护一个优先队列，保存每一站的油量，大的放在队首，当需要加油时进行出队操作，这样就能达到在油量最大的地方加油的目的
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curPos = 0, leftFuel = startFuel;
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int i = 0;
        int refuelingTimes = 0;

        while (curPos + leftFuel < target) {
            // 将目标点也作为加油站，只不过可加油量为0
            int next = target;
            // target 前有加油站，去往下一站
            if (i < stations.length && stations[i][0] < target) {
                next = stations[i][0];
            }

            // 到不了下一站，需要加油了
            while (curPos + leftFuel < next) {
                // 无油可加
                if (pq.isEmpty()) {
                    return -1;
                }
                // 加最多的油，这样才能走得更远
                leftFuel += pq.poll();
                refuelingTimes++;
            }

            // 到了下一站，扣除油耗，更新位置
            leftFuel -= (next - curPos);
            curPos = next;
            // 更新队列，收集油量
            if (stations[i][1] > 0) {
                pq.offer(stations[i][1]);
            }
            i++;    // 下一站
        }

        return curPos + leftFuel >= target ? refuelingTimes : -1;
    }
}
