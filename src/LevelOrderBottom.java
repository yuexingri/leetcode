import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> rootList = new LinkedList<TreeNode>();
        List<Integer> rootVal = new LinkedList<Integer>();
        rootList.add(root);
        rootVal.add(root.val);
        levelOrderInner(rootList, ret);
        ret.add(rootVal);
        return ret;
    }

    private void levelOrderInner(List<TreeNode> treeNodes, List<List<Integer>> ret) {
        List<Integer> curNodeVals = new LinkedList<Integer>();
        List<TreeNode> nextTreeNodes = new LinkedList<TreeNode>();
        for (TreeNode node : treeNodes) {
            if (node.left != null) {
                nextTreeNodes.add(node.left);
            }
            if (node.right != null) {
                nextTreeNodes.add(node.right);
            }
        }
        if (!nextTreeNodes.isEmpty()) {
            levelOrderInner(nextTreeNodes, ret);
            curNodeVals.addAll(nextTreeNodes.stream().map(treeNode -> treeNode.val).collect(Collectors.toList()));
            ret.add(curNodeVals);
        }
    }
}
