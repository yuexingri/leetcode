public class BalancedBinaryTree {

    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalance;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}
