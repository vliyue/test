package cn.vliyue.test.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> q = new LinkedList<>();
        helper(q, root, 0);
        return q;
    }

    private void helper(LinkedList<List<Integer>> q, TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (q.size() == i) {
            q.offerFirst(new ArrayList<>());
        }
        q.get(i).add(root.val);
        helper(q, root.left, i + 1);
        helper(q, root.right, i + 1);
    }
}
