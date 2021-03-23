package lc341FlattenNestedListIterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NestedIteratorTest {
    @Test
    void testNestedIterator() {
        List<NestedInteger> nestedList1 = new ArrayList<>();
        nestedList1.add(new SimpleNestedInteger(List.of(new SimpleNestedInteger(1), new SimpleNestedInteger(1))));
        nestedList1.add(new SimpleNestedInteger(2));
        nestedList1.add(new SimpleNestedInteger(List.of(new SimpleNestedInteger(1), new SimpleNestedInteger(1))));
        assertArrayEquals(new Integer[]{1,1,2,1,1}, iterateNestedList(new NestedIterator(nestedList1)));

        nestedList1.clear();
        nestedList1.add(new SimpleNestedInteger(1));
        List<NestedInteger> list = new ArrayList<>();
        list.add(new SimpleNestedInteger(4));
        list.add(new SimpleNestedInteger(List.of(new SimpleNestedInteger(6))));
        nestedList1.add(new SimpleNestedInteger(list));
        assertArrayEquals(new Integer[]{1,4,6}, iterateNestedList(new NestedIterator(nestedList1)));
    }

    private Integer[] iterateNestedList(NestedIterator iterator) {
        List<Integer> res = new ArrayList<>();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        return res.toArray(new Integer[]{});
    }

    static class SimpleNestedInteger implements NestedInteger {
        private final Object element;

        public SimpleNestedInteger(Object obj) {
            this.element = obj;
        }

        @Override
        public boolean isInteger() {
            return (element instanceof Integer);
        }

        @Override
        public Integer getInteger() {
            return (Integer) element;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) element;
        }
    }
}