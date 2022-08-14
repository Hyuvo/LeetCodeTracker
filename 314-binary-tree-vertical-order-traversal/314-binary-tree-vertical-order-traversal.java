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

// Optimization get the range of column index, then retrieve the result accordingly

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        // use map to track the column index of nodes
        // <column, list of nodes' value on that column>
        Map<Integer, ArrayList<Integer>> columnMap = new HashMap<>();
        // queue for BFS
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        // Init for BFS
        // root index is 0, left -1, right + 1
        int column = 0;
        q.offer(new Pair(root, column));
        int minCol = 0, maxCol = 0;
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode current = pair.getKey();
            column = pair.getValue();
            
            if (current != null) {
                // preorder
                // track the column
                if (!columnMap.containsKey(column)) {
                    // if no such column record, open up space
                    // Note: list of integer(nodes' values)
                    columnMap.put(column, new ArrayList<Integer>());
                }
                columnMap.get(column).add(current.val);
                
                // traverse from left to right
                // see if the range expands
                minCol = Math.min(column, minCol);
                maxCol = Math.max(column, maxCol);
                
                q.offer(new Pair(current.left, column - 1));
                q.offer(new Pair(current.right, column + 1));
                               
            }           
        }
        
        // retrieve the result within the range of col
        for (int i = minCol; i <= maxCol; ++i) {
            result.add(columnMap.get(i));
        }
        
        return result;
        
    }
}



// class Solution {
//     public List<List<Integer>> verticalOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) return result;
        
//         // <column, list of nodes in this column>
//         Map<Integer, ArrayList> columnMap = new HashMap<>();
//         // use queue to control traversel order
//         Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        
//         // init for BFS
//         // the column index of root is 0, then +1 for right, -1 for left
//         int column = 0;
//         q.offer(new Pair(root, column));
        
//         while (!q.isEmpty()) {
//             Pair<TreeNode, Integer> pair = q.poll();
//             TreeNode current = pair.getKey();
//             column = pair.getValue();
            
//             // preorder position
//             if (current != null) {
//                 // if no record for this column
//                 if (!columnMap.containsKey(column)) {
//                     // open up space, as need to return List<List<Integer>>, the arraylist here is for the value of the node
//                     columnMap.put(column, new ArrayList<Integer>());
//                 }                
//                 // add current node
//                 columnMap.get(column).add(current.val);
                
//                 // traversel left to right
//                 q.offer(new Pair(current.left, column - 1));
//                 q.offer(new Pair(current.right, column + 1));             
//             }            
//         }
        
//         List<Integer> sortedKeys = new ArrayList<Integer>(columnMap.keySet()); 
//         // sort result per column ascending order
//         Collections.sort(sortedKeys);
//         for (int key : sortedKeys) {
//             result.add(columnMap.get(key));
//         }
        
//         return result;
//     }
// }

