import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode cur = root;
//        List<Integer> ret = new ArrayList<Integer>();
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pop();
//                ret.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return ret;
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        inorderInner(root, ret);
        return ret;
    }

    private void inorderInner(TreeNode node, List<Integer> ret) {
        if (node.left != null) {
            inorderInner(node.left, ret);
        }
        if (node != null) {
            ret.add(node.val);
        }
        if (node.right != null) {
            inorderInner(node.right, ret);
        }
    }
}
