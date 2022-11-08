/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // original node => cloned node
    private HashMap<Node, Node> oriToClone = new HashMap();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        traverse(node);
        return oriToClone.get(node);
    }
    
    // dfs
    public void traverse(Node node) {
        if (node == null) return;
        if (oriToClone.containsKey(node)) return;
        oriToClone.put(node, new Node(node.val));
        
        for (Node neighbor : node.neighbors) {
            traverse(neighbor);
            oriToClone.get(node).neighbors.add(oriToClone.get(neighbor));
        }
    }
}