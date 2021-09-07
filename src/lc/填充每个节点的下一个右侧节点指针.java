package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 */

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class 填充每个节点的下一个右侧节点指针 {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        link(nodes);
        return root;
    }

    /**
     * 按层遍历，需要O(n)额外空间
     *
     * @param nodes
     */
    private static void link(List<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Node> nextNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null) {
                nextNodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nextNodes.add(nodes.get(i).right);
            }
            if (i == nodes.size() - 1) {
                break;
            }
            nodes.get(i).next = nodes.get(i + 1);
        }
        System.err.println();

        link(nextNodes);
    }

    public static Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        // 利用next指针拿到父子点的兄弟节点的子节点的引用
        Node leftFirst = root;
        while (leftFirst.left != null) {
            Node left = leftFirst.left;
            Node right = leftFirst.right;
            left.next = right;
            Node pre = right;
            Node next = leftFirst.next;
            while (next != null) {
                pre.next = next.left;
                next.left.next = next.right;
                pre = next.right;
                next = next.next;
            }
            leftFirst = leftFirst.left;
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect1(root);
    }

}
