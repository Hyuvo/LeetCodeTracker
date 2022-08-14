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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        // <column, list of nodes in this column>
        Map<Integer, ArrayList> columnMap = new HashMap<>();
        // use queue to control traversel order
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        
        // init for BFS
        // the column index of root is 0, then +1 for right, -1 for left
        int column = 0;
        q.offer(new Pair(root, column));
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode current = pair.getKey();
            column = pair.getValue();
            
            // preorder position
            if (current != null) {
                // if no record for this column
                if (!columnMap.containsKey(column)) {
                    // open up space, as need to return List<List<Integer>>, the arraylist here is for the value of the node
                    columnMap.put(column, new ArrayList<Integer>());
                }                
                // add current node
                columnMap.get(column).add(current.val);
                
                // traversel left to right
                q.offer(new Pair(current.left, column - 1));
                q.offer(new Pair(current.right, column + 1));             
            }            
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(columnMap.keySet()); 
        // sort result per column ascending order
        Collections.sort(sortedKeys);
        for (int key : sortedKeys) {
            result.add(columnMap.get(key));
        }
        
        return result;
    }
}