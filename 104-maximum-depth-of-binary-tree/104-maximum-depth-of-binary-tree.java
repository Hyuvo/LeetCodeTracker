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


// class Solution {
//     private int currentDepth = 0;
//     private int maxDepth = 0;
    
//     public int maxDepth(TreeNode root) {
//         traverse(root);
//         return maxDepth;
//     }
    
//     public void traverse(TreeNode root) {
//         if(root == null) return;
        
//         // prior to traversing the node
//         currentDepth++;
        
//         // reach leaf node, update the max depth
//         if (root.left == null && root.left == null) {
//             maxDepth = Math.max(maxDepth, currentDepth);
//         }
        
//         traverse(root.left);
//         traverse(root.right);
        
//         // leaving the node
//         currentDepth--;            
//     }
    
// }

class Solution {
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int depth = 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        depth = Math.max(leftHeight, rightHeight) + 1;
        return depth;
    }
}