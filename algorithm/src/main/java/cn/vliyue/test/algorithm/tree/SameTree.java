package cn.vliyue.test.algorithm.tree;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == q) {
            return true;
        } else {
            return false;
        }
    }
}
