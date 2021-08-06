package lc662MaximumWidthOfBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void widthOfBinaryTree() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        assertEquals(4, solution.widthOfBinaryTree(root));

        root.left.right = null;
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        assertEquals(8, solution.widthOfBinaryTree(root));
    }
}