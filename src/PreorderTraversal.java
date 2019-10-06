import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ret = new ArrayList<>();
//        preorderTraversalInner(root, ret);
//        return ret;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            ret.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return ret;
    }

//    public void preorderTraversalInner(TreeNode treeNode, List<Integer> ret) {
//        if (treeNode == null) {
//            return;
//        }
//        ret.add(treeNode.val);
//        if (treeNode.left != null) {
//            preorderTraversalInner(treeNode.left, ret);
//        }
//        if (treeNode.right != null) {
//            preorderTraversalInner(treeNode.right, ret);
//        }
//    }
}
