package cn.vliyue.test.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTreeFromInPost {

    public static void main(String[] args) {
        new BuildTreeFromInPost().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }

    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inMap.get(root.val);
        // 见题解：preEnd不同于i
        root.left = buildTree(preorder, preStart + 1, i - inStart + preStart, inorder, inStart, i - 1);
        root.right = buildTree(preorder, i - inStart + preStart + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }
}
