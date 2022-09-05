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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    // validate root.val is within low and high bound
    public boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        
        if (low != null && root.val <= low) {
            return false;
        }
        
        if (high != null && root.val >= high) {
            return false;
        }
        
        // traverse the left and right sub-tree to validate
        // the upper bound of left-sub is root.val, lower bound of right-sub is root.val
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    } 
}