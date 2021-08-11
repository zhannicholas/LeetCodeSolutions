package lc39CombinationSum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void combinationSum() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(ans);
    }
}