package lc57InsertInterval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void insert() {
        Solution solution = new Solution();
        solution.insert(new int[][]{{2,5},{6,7},{8,9}}, new int[]{0,1});
        solution.insert(new int[][]{{1,5}}, new int[]{2,7});
        solution.insert(new int[][]{{1,5}}, new int[]{2,3});
        solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        solution.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        solution.insert(new int[][]{}, new int[]{5,7});
    }
}