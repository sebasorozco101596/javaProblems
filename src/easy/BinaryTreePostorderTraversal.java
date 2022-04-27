package easy;

import different_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> treeOrdered = new ArrayList<>();
        helper(root, treeOrdered);
        return treeOrdered;
    }

    public void helper(TreeNode root, ArrayList<Integer> treeToOrder) {
        if (root == null ) return;
        helper(root.left,treeToOrder);
        helper(root.right, treeToOrder);
        treeToOrder.add(root.val);
    }

}
