package lc341FlattenNestedListIterator;

/*
341. 扁平化嵌套列表迭代器
给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。



示例 1:

输入: [[1,1],2,[1,1]]
输出: [1,1,2,1,1]
解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
示例 2:

输入: [1,[4,[6]]]
输出: [1,4,6]
解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private final List<Integer> flattenList;
    private int cursor;
    private final int size;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattenList = new ArrayList<>();
        this.cursor = 0;
        flattenNestedList(nestedList, this.flattenList);
        this.size = flattenList.size();
    }

    @Override
    public Integer next() {
        return flattenList.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }

    private void flattenNestedList(List<NestedInteger> nestedList, List<Integer> flattenList) {
        for (NestedInteger nestedInteger: nestedList) {
            if (nestedInteger.isInteger()) {
                flattenList.add(nestedInteger.getInteger());
            } else {
                flattenNestedList(nestedInteger.getList(), flattenList);
            }
        }
    }
}
