/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String SEP = ",";
    private String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    // use void, sb is outside
    public void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if(root == null) {
            sb.append(NULL).append(SEP);// don't forget sep
            return;
        }
        // preorder 
        sb.append(root.val).append(SEP);
        //StringBuilder append(X x): This method appends the string representation of the X type argument to the sequence.
        
        // traverse left and right sub
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // use list to catch nodes
        LinkedList<String> nodes = new LinkedList<>();
        for(String node : data.split(SEP)) {
            nodes.addLast(node);
        }
        return deserialize(nodes);
        
    }
    
    public TreeNode deserialize(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty()) return null;
        // the first node should be the current root
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        // preorder traversal
        TreeNode root = new TreeNode(Integer.parseInt(first));        
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));