package lc;

import java.util.Stack;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 合并二叉树 {
    /**
     * 直接改树1，返回的是树1
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode temp1 = root1;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(temp1);
        TreeNode temp2 = root2;
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(temp2);
        temp1.val += temp2.val;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode pop1 = stack1.pop();
            TreeNode pop2 = stack2.pop();
            // 如果树1和树2重叠，值就相加
            // 如果树1节点为null，就连接上树2的节点
            if (pop2 != null) {
                if (pop1.right == null) {
                    pop1.right = pop2.right != null ? new TreeNode(pop2.right.val) : null;
                } else if (pop2.right != null) {
                    pop1.right.val += pop2.right.val;
                }
                if (pop1.left == null) {
                    pop1.left = pop2.left != null ? new TreeNode(pop2.left.val) : null;
                } else if (pop2.left != null) {
                    pop1.left.val += pop2.left.val;
                }
            }
            // 树2必须根据树1的遍历顺序
            if (pop1 != null) {
                stack1.push(pop1.right);
                stack1.push(pop1.left);
                stack2.push(pop2 == null ? null : pop2.right);
                stack2.push(pop2 == null ? null : pop2.left);
            }
        }
        return root1;
    }

    /**
     * 返回新的二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergeTree = new TreeNode(root1.val + root2.val);
        mergeTree.left = mergeTrees1(root1.left, root2.left);
        mergeTree.right = mergeTrees1(root1.right, root2.right);
        return mergeTree;
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(9);
        treeRoot.left = new TreeNode(7);
        treeRoot.right = new TreeNode(10);
        treeRoot.left.left = new TreeNode(6);
        treeRoot.left.right = new TreeNode(8);
        treeRoot.right.left = new TreeNode(5);
        treeRoot.right.left.right = new TreeNode(13);
        TreeNode root2 = new TreeNode(1);
        print(mergeTrees1(root2, treeRoot));
    }

    static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.err.println(root.val);
        print(root.left);
        print(root.right);
    }
}
