package easy;
import different_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursiveApproach {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode pre = current.left;
                while ((pre.right != null) && (pre.right != current)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    nodes.add(current.val);
                    current = current.right;
                }
            } else {
                nodes.add(current.val);
                current = current.right;
            }
        }
        return nodes;
    }

    // With a helper function

    public List<Integer> inorderTraversalOptimal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

}
