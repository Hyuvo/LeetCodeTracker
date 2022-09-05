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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // reache the end, put val
        if (root == null) return new TreeNode(val);
        
        // greater than current node, should be in the right sub
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        // should be in the left sub
        if (root.val > val) {
            root.left =  insertIntoBST(root.left, val);
        }
        
        return root;
    }
}