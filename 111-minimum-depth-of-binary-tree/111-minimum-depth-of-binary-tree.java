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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int depth = 1;
        
        while(!q.isEmpty()) {
            // get level size
            int size = q.size();
            // traverse current level
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                // check if it's leaf
                if (current.left == null && current.right == null) {
                    return depth;
                }
                // add current node's neighbors to the q
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);    
            }
            ++depth;
        }
        
        return depth;
    }
}