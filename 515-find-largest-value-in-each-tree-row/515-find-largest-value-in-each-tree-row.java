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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int levelMax = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                levelMax = Math.max(levelMax, current.val);
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }                
            }
            result.add(levelMax);
        }
        return result;
    }
    
    
}