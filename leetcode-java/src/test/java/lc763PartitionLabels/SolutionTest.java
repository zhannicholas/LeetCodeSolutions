package lc763PartitionLabels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partitionLabels() {
        Solution solution = new Solution();
        assertArrayEquals(new Integer[]{9,7,8}, solution.partitionLabels("ababcbacadefegdehijhklij").toArray());
    }
}