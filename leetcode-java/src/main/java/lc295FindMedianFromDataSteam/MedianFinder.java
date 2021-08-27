package lc295FindMedianFromDataSteam;

import java.util.PriorityQueue;
import java.util.Queue;

/*
295. 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder {
    /*
    注意题目提到的是有序列表。
    考虑[1,2,3,4,5]这种数量为奇数的情况，可以将它分为三部分：[1,2]，[3]，[4,5]，中位数是中间部分
    而对于[1,2,3,4,5,6] 这种数量为偶数的情况，可以将它分为两部分：[1,2,3],[4,5,6]，中位数是第一部分的最大值与第二部分的最小值的平均值
    所以我们可以考虑维护两个优先队列，分别对应于第一部分和第二部分的情况
     */
    private final Queue<Integer> maxPq;   // 第一部分，队头放最大值
    private final Queue<Integer> minPq;   // 第二部分，队头放最小值

    /** initialize your data structure here. */
    public MedianFinder() {
        maxPq = new PriorityQueue<>((a, b) -> a - b);
        minPq = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minPq.isEmpty() || num <= minPq.peek()) {
            minPq.offer(num);
            if (minPq.size() > maxPq.size() + 1) {
                maxPq.offer(minPq.poll());
            }
        } else {
            maxPq.offer(num);
            if (maxPq.size() > minPq.size()) {
                minPq.offer(maxPq.poll());
            }
        }

    }

    public double findMedian() {
        if (minPq.size() > maxPq.size()) {
            return minPq.peek() * 1.0;
        } else {
            return (minPq.peek() + maxPq.peek()) / 2.0;
        }
    }
}
