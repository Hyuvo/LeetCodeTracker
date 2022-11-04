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
    List<Integer> result = new LinkedList();
    int depth = 0;
    public List<Integer> rightSideView(TreeNode root) {   
        traverse(root);
        return result;        
    }
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        // control level at preorder
        depth++;
        
        if (result.size() < depth) result.add(root.val);   
        // right sub first
        traverse(root.right);   
        traverse(root.left);
        
        // post-order
        depth--;
    }
}