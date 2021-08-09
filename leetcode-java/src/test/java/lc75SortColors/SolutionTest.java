package lc75SortColors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortColors() {
        Solution solution = new Solution();
        int[] colors = new int[]{1,2,0};
        solution.sortColors(colors);
        assertArrayEquals(new int[]{0,1,2}, colors);

        int[] colors1 = new int[]{2,0,2,1,1,0};
        solution.sortColors(colors1);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, colors1);

        int[] colors2 = new int[]{2,1,0};
        solution.sortColors(colors2);
        assertArrayEquals(new int[]{0,1,2}, colors2);

        int[] colors3 = new int[]{0};
        solution.sortColors(colors3);
        assertArrayEquals(new int[]{0}, colors3);
    }
}