package cn.vliyue.test.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            if (current != null) {
                current = getTreeNode(list, stack, current);
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.pop();
                current = getTreeNode(list, stack, current);
            }
        }
        return list;
    }

    private TreeNode getTreeNode(List<Integer> list, Stack<TreeNode> stack, TreeNode current) {
        list.add(current.val);
        if (current.right != null) {
            stack.push(current.right);
        }
        current = current.left;
        return current;
    }
}
