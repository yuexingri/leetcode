public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricInner(root.left, root.right);
    }

    private boolean isSymmetricInner(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && isSymmetricInner(leftNode.right, rightNode.left) && isSymmetricInner(leftNode.left, rightNode.right);
    }
}
