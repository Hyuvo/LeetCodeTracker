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
    public int countNodes(TreeNode root) {
        // track the left height and right height
        int lHeight = 0, rHeight = 0;
        TreeNode l = root, r = root;
        while(l != null) {
            l = l.left;
            lHeight++;
        }
        while(r != null) {
            r = r.right;
            rHeight++;
        }
        
        // if it's a perfect binary tree
        if (lHeight == rHeight) {
            return (int) Math.pow(2, lHeight) - 1;
        }
        
        // if not perfect
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}