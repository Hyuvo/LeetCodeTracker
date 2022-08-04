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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }
    
    public TreeNode find(TreeNode root, HashSet<Integer> values) {
        // base case
        if (root == null) return null;
        
        // preorder
        if (values.contains(root.val)) {
            return root;
        }
        
        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    
        
    }
}