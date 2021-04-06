package lc80RemoveDuplicatesFromSortedArrayII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        assertEquals(5, solution.removeDuplicates(nums1));
        assertArrayEquals(new int[]{1,1,2,2,3,3}, nums1);

        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
        assertEquals(7, solution.removeDuplicates(nums2));
        assertArrayEquals(new int[]{0,0,1,1,2,3,3,3,3}, nums2);
    }
}