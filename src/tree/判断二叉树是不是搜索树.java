package tree;

public class 判断二叉树是不是搜索树 {

    public static boolean isSearchTree(TreeNode<Integer> node) {
        if (node == null) {
            return true;
        }
        //用后序遍历
        boolean leftTree = isSearchTree(node.left);
        boolean rightTree = isSearchTree(node.right);
        if (!(leftTree && rightTree)) {
            return false;
        }
        boolean left = node.left == null || node.left.getValue() < node.getValue();
        boolean right = node.right == null || node.right.getValue() >= node.getValue();
        return left && right;
    }

    public static void main(String[] args) {
        //顺序 9 7 10 6 8 5 13
        TreeNode<Integer> treeRoot = new TreeNode<>(10);
        treeRoot.setLeft(new TreeNode<>(5));
        treeRoot.setRight(new TreeNode<>(15));

        treeRoot.getLeft().setLeft(new TreeNode<>(6));
        treeRoot.getLeft().setRight(new TreeNode<>(8));

        treeRoot.getRight().setLeft(new TreeNode<>(12));
        treeRoot.getRight().getLeft().setRight(new TreeNode<>(18));
        System.out.println(isSearchTree(treeRoot));
        treeRoot.print(treeRoot);
    }

}
