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
    private HashMap<Integer, Integer> valToIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; ++i) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                int[] postorder, int postStart, int postEnd) {
        //base case
        if (inStart > inEnd) return null;
        
        int rootVal = postorder[postEnd];
        int rootIndex = valToIndex.get(rootVal);
        int leftSize = rootIndex - inStart;
        
        // recursion
        TreeNode root = new TreeNode(rootVal);
        // start + left size - 1 is the last node of the left subtree
        root.left = build(inorder, inStart, rootIndex - 1,
                         postorder, postStart, postStart+leftSize-1);
        root.right = build(inorder, rootIndex + 1, inEnd,
                          postorder, postStart + leftSize, postEnd - 1);
        
        return root;
        
    }
}