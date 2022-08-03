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
    
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
        
    }
    
    public List<TreeNode> build(int lower, int upper) {
        LinkedList<TreeNode> result = new LinkedList<>();
        // base case
        if (lower > upper) {
            result.add(null);
            return result;
        }
        
        // for each node in this interval to be root
        for (int i = lower; i <= upper; ++i) {
            // build the left and right subtrees
            List<TreeNode> leftTree = build(lower, i - 1);
            List<TreeNode> rightTree = build(i + 1, upper);
            
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
            
        }
        return result;
        
    }
}