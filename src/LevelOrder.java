import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<TreeNode> rootList = new LinkedList<TreeNode>();
        rootList.add(root);
        levelOrderInner(rootList, ret);
        return ret;
    }

    private void levelOrderInner(List<TreeNode> treeNodes, List<List<Integer>> ret) {
        List<Integer> curNodeVals = new LinkedList<Integer>();
        List<TreeNode> nextTreeNodes = new LinkedList<TreeNode>();
        for (TreeNode node : treeNodes) {
            curNodeVals.add(node.val);
            if (node.left != null) {
                nextTreeNodes.add(node.left);
            }
            if (node.right != null) {
                nextTreeNodes.add(node.right);
            }
        }
        ret.add(curNodeVals);
        if (!nextTreeNodes.isEmpty()) {
            levelOrderInner(nextTreeNodes, ret);
        }
    }
}
