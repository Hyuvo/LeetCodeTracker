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
        return find(root, p, q);
    }
    
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        
        // preorder position, return if one of them is the lca
        if (root.val == p.val || root.val == q.val) {
            // the other one must present in its subtree
            return root;
        }
        
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        
        // post order, if both node exist, root is the lca
        if (left != null && right != null) {
            return root;
        }
        // return the side that found the nodes
        return left != null ? left : right;
    }
}