package lc692TopKFrequentWords;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
692. 前K个高频单词
给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。


示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。


注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。


扩展练习：

尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 先统计每个单词的出现频率
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word: words) {
            Integer frequency = frequencyMap.get(word);
            if (frequency == null) {
                frequencyMap.put(word, 1);
            } else {
                frequencyMap.put(word, frequency + 1);
            }
        }

        // 频率低的优先级更高，这样当队列容量达到 k 时，出队的元素就是频率最低的
        Queue<WordFrequency> queue = new PriorityQueue<>(new Comparator<WordFrequency>() {
            @Override
            public int compare(WordFrequency w1, WordFrequency w2) {
                int diff = w2.frequency - w1.frequency;
                if (diff == 0) {
                    // 频率相同比较字典序
                    return w1.word.compareTo(w2.word);
                }
                return diff;
            }
        });
        int k1 = k;
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            queue.offer(new WordFrequency(entry.getKey(), entry.getValue()));
            if (k1 > 0) {
                k1--;
            } else {
                if (entry.getValue() > queue.peek().frequency) {
                    queue.poll();
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().word);
        }
        return ans;
    }
}

class WordFrequency {
    String word;
    int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
