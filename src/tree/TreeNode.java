package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的结点
 */
public class TreeNode<T> {

    public TreeNode<T> left;

    public TreeNode<T> right;

    private T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode<T> setLeft(TreeNode<T> node) {
        this.left = node;
        return node;
    }

    public TreeNode<T> setRight(TreeNode<T> node) {
        this.right = node;
        return node;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void pre(TreeNode treeRoot) {
        if (treeRoot == null) {
            return;
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
//            if (tempNode.left != null) {
//                queue.add(tempNode.left);
//            }
//            if (tempNode.right != null) {
//                queue.add(tempNode.right);
//            }
            System.err.print(tempNode.value + "\t");
        }
    }

    public void printLayer(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> curLayer = new LinkedList<>();
        Queue<Queue<TreeNode>> queueLayer = new LinkedList<>();
        curLayer.add(treeNode);
        queueLayer.add(new LinkedList<>(curLayer));
        Queue<TreeNode> nextLayer = new LinkedList<>();
        while (!curLayer.isEmpty()) {
            TreeNode poll = curLayer.poll();
            if (poll.left != null) {
                nextLayer.add(poll.left);
            }
            if (poll.right != null) {
                nextLayer.add(poll.right);
            }
            if (curLayer.isEmpty()) {
                curLayer = new LinkedList<>(nextLayer);
                queueLayer.add(nextLayer);
                nextLayer = new LinkedList<>();
            }
        }
        while (!queueLayer.isEmpty()) {
            Queue<TreeNode> poll = queueLayer.poll();
            while (!poll.isEmpty()) {
                TreeNode node = poll.poll();
                System.err.print(node.value + "\t");
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
//        //顺序 9 7 10 6 8 5 13
//        TreeNode<Integer> treeRoot = new TreeNode<>(9);
//        treeRoot.setLeft(new TreeNode<>(7));
//        treeRoot.setRight(new TreeNode<>(10));
//        treeRoot.getLeft().setLeft(new TreeNode<>(6));
//        treeRoot.getLeft().setRight(new TreeNode<>(8));
//        treeRoot.getRight().setLeft(new TreeNode<>(5));
//        treeRoot.getRight().getLeft().setRight(new TreeNode<>(13));
////        treeRoot.pre(treeRoot);
////        System.err.println();
//        treeRoot.printLayer(treeRoot);

        int n = 56;
        System.err.println(Integer.toBinaryString(n));
        int rer = 0;
        for (int i = 32; i > 0; i--) {
            int temp = (n >> i - 1) & 1;
            temp = temp << 32 - i;
            rer |= temp;
        }
        System.err.println(Integer.toBinaryString(rer));

    }
}
