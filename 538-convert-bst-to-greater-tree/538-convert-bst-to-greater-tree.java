/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        
        // sum all nodes from right subtree
        traverse(root.right);
        // inorder
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}