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
    // store val-index of inorder to a map
    private HashMap<Integer, Integer> valToIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; ++i) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }
    // given a preoder list and an inorder list, build the tree and return the root
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                         int[] inorder, int inStart, int inEnd) {
        //base case
        if (preStart > preEnd) return null;
        // the root is the first node of preorder
        int rootVal = preorder[preStart];
        // get the root index in inorder
        int rootIndex = valToIndex.get(rootVal);
        //the size of the left subtree
        int leftLen = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        
        // recursion
        root.left = build(preorder, preStart+1, preStart + leftLen,
                         inorder, inStart, rootIndex-1);
        root.right = build(preorder, preStart + leftLen+1, preEnd,
                          inorder, rootIndex+1, inEnd);
        
        return root;
        
    }
}