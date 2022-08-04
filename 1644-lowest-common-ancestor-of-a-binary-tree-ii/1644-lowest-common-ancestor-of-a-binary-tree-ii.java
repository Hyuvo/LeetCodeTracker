/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean foundP = false, foundQ = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // nodes may not exist
        // need complete search of the entire tree
        TreeNode result = find(root, p, q);
        if (!foundP || !foundQ) return null;
        return result;
    }
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return null;
        
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) foundP = true;
            if (root.val == q.val) foundQ = true;
            return root;
        }
        
        return left != null ? left : right;
    }

}