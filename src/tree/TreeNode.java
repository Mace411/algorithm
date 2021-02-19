package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的结点
 */
public class TreeNode {

    public TreeNode left;

    public TreeNode right;

    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode setLeft(TreeNode node) {
        this.left = node;
        return node;
    }

    public TreeNode setRight(TreeNode node) {
        this.right = node;
        return node;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void pre(TreeNode treeRoot) {
        if (treeRoot == null) {
            return ;
        }
        System.err.print(treeRoot.value + "\t");
        pre(treeRoot.getLeft());
        pre(treeRoot.getRight());
    }

    public void print(TreeNode treeRoot) {
        if (treeRoot == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeRoot);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
            System.err.print(tempNode.value + "\t");
        }
    }

    public static void main(String[] args) {
        //顺序 9 7 10 6 8 5 13
        TreeNode treeRoot = new TreeNode(9);
        treeRoot.setLeft(new TreeNode(7));
        treeRoot.setRight(new TreeNode(10));
        treeRoot.getLeft().setLeft(new TreeNode(6));
        treeRoot.getLeft().setRight(new TreeNode(8));
        treeRoot.getRight().setLeft(new TreeNode(5));
        treeRoot.getRight().getLeft().setRight(new TreeNode(13));
        treeRoot.pre(treeRoot);
        System.err.println();
        treeRoot.print(treeRoot);
    }
}
