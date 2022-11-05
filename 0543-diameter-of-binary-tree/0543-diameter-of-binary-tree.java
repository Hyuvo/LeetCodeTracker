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
    int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiam;
    }
    
    // return the depth of a tree
    // depth is the edge # to root, so the diameter is the sum of depths of the subtrees
    public int maxDepth(TreeNode root) {
        // base case;
        if (root == null) return 0;
        // diameter = left maxD + right maxD             
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // post-order: maintain max diameter
        maxDiam = Math.max(maxDiam, leftMax + rightMax);
        // depth = the depth of the deeper subtree
        return Math.max(leftMax, rightMax) + 1;
    }
}