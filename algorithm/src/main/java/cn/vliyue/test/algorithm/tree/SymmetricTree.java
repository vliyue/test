package cn.vliyue.test.algorithm.tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (right != null && left != null && right.val == left.val) {
            return isSymmetric(right.left, left.right) && isSymmetric(right.right, left.left);
        } else if (right == left) {
            return true;
        } else {
            return false;
        }
    }
}
