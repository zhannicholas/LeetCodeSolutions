package lcof21TiaoZhengShuZuShunXuShiJiShuWeiYuOuShuQianMian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exchange() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{1,3,2,4}, solution.exchange(new int[]{1,2,3,4}));
    }
}