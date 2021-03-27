package lc26RemoveDuplicatesFromSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        int[] arr1 = new int[]{1,1,2};
        int len1 = solution.removeDuplicates(arr1);
        assertEquals(2, len1);
        assertArrayEquals(new int[]{1,2}, firstK(arr1, len1));

        int[] arr2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len2 = solution.removeDuplicates(arr2);
        assertEquals(5, len2);
        assertArrayEquals(new int[]{0,1,2,3,4}, firstK(arr2, len2));

        int[] arr3 = new int[]{1};
        int len3 = solution.removeDuplicates(arr3);
        assertEquals(1, len3);
        assertArrayEquals(new int[]{1}, firstK(arr3, len3));
    }

    private int[] firstK(int[] arr, int k) {
        int[] res = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}