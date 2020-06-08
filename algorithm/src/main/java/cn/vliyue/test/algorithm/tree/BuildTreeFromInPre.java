package cn.vliyue.test.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTreeFromInPre {

    public static void main(String[] args) {
        new BuildTreeFromInPre().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }

    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        return buildTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int i = inMap.get(root.val);
        root.left = buildTree(inorder, inStart, i - 1, postOrder, postStart, i - inStart + postStart - 1);
        root.right = buildTree(inorder, i + 1, inEnd, postOrder, i - inStart + postStart, postEnd - 1);
        return root;
    }
}
