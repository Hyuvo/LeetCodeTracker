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
    // the inorder traversal of a BST is ascending
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    int rank = 0, result = 0;
    private void traverse(TreeNode root, int k) {
        // base case
        if (root == null) return;
        traverse(root.left, k);
        // inorder position
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }       
        traverse(root.right, k);
    }
}