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
    //use hash to store the value-index pair in postorder
    private HashMap<Integer, Integer> valToIndex = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0; i < postorder.length; ++i) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }
    
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                         int[] postorder, int postStart, int postEnd) {
        //base case
        if (preStart > preEnd) return null;
        // meet at root
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        
        //root is the first of preorder
        int rootVal = preorder[preStart];
        // left root is the 2nd node in preorder
        int leftRootVal = preorder[preStart+1];
        int leftRootIndex = valToIndex.get(leftRootVal);
        
        TreeNode root = new TreeNode(rootVal);
        // the last node in the left subpart of postorder is the root of the left subtree  
        // get left size from postorder
        int leftSize = leftRootIndex - postStart + 1;
        
        root.left = build(preorder, preStart+1, preStart + leftSize,
                         postorder, postStart, leftRootIndex);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                          postorder, leftRootIndex + 1, postEnd - 1);
        
        return root;
    }
}