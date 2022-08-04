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
        if (q.val < p.val) {
            return find(root, q, p);
        }
        
        if (root == null) return null;
        
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        
        if (root.val < p.val) {
            return find(root.right, p, q);
        } else if (root.val > q.val) {
            return find(root.left, p, q);
        }
        
        return null;
    }
}