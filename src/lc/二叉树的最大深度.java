package lc;

import tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        return next(root);
    }

    private static int next(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(next(node.left), next(node.right)) + 1;
    }

}
