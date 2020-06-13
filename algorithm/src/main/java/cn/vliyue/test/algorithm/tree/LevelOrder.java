package cn.vliyue.test.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> q = new LinkedList<>();
        helper(q, root, 0);
        return q;
    }

    private void helper(List<List<Integer>> q, TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (q.size() == i) {
            q.add(new ArrayList<>());
        }
        q.get(i).add(root.val);
        helper(q, root.left, i + 1);
        helper(q, root.right, i + 1);
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            r.add(new ArrayList<>());
            int temp = count;
            count = 0;
            for (int i = 0; i < temp; i++) {
                TreeNode t = queue.poll();
                r.get(level).add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                    count++;
                }
                if (t.right != null) {
                    queue.add(t.right);
                    count++;
                }
            }
            level++;
        }
        return r;
    }

}
