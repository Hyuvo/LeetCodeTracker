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
    //count each subtree
    private HashMap<String, Integer> subtreeCount = new HashMap<>();
    private List<TreeNode> result = new LinkedList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }
    
    public String traverse(TreeNode root) {
        //base case
        if (root == null) return "#";
        
        //traverse
        String left = traverse(root.left);
        String right = traverse(root.right);
        //postorder get subtree info
        String subtree = root.val + "," + left + "," + right;
        
        int freq = subtreeCount.getOrDefault(subtree, 0);
        if (freq == 1) {
            result.add(root);
        }
        subtreeCount.put(subtree, freq + 1);
        
        return subtree;
        
        
    }
}