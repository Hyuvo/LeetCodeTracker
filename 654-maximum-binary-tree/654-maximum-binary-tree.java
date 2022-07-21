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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildSubtree(nums, 0, nums.length-1);
    }
    
    public TreeNode buildSubtree(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for (int i = left; i <= right; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = buildSubtree(nums, left, index-1);
        root.right = buildSubtree(nums, index+1, right);
        
        return root;
        
    }
}