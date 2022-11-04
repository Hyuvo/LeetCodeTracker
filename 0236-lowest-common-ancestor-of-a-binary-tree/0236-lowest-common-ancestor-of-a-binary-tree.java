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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        // pre-order: if the p or q is ancestor itself
        if (root == p || root == q) return root;
        
        // find in both sub-trees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if both node can be found in subtrees, root is the common ancenstor
        if (left != null && right != null) return root;
        
        // return either non-null node or null
        return left != null ? left : right;
    }
}