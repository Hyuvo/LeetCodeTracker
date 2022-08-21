class MapSum {
    // same to 1804
    // a straightforward TrieMap
    private TrieMap map;
    public MapSum() {
        map = new TrieMap();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        
        if (!map.hasPrefix(prefix)) return 0;
        int sum = 0;
        for (String key : map.keysWithPrefix(prefix)) {
            sum += map.get(key);
        }
        return sum;
    }
}

class TrieMap {
    private static final int R = 256;
    private int size = 0;
    private class TrieNode {
        Integer val = null;
        TrieNode[] children = new TrieNode[R];
    }
    private TrieNode root = null;
    
    /* methods */
    public void put(String key, int val) {
        root = put(root, key, val, 0);
    }
    
    private TrieNode put(TrieNode node, String key, int val, int i) {
        // recursively attach node
        if (node == null) {
            node = new TrieNode();
        }
        if (i == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }
    
    public List<String> keysWithPrefix(String prefix) {
        List<String> result = new LinkedList<>();
        TrieNode node = getNode(root, prefix);
        if (node == null) {
            return result;
        }
        StringBuilder path = new StringBuilder(prefix);
        traverse(node, path, result);
        return result;
    }
    private void traverse(TrieNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            // reach the end
            return;
        }
        if (node.val != null) {
            // find one valid key
            result.add(path.toString());
        }
        // traversal
        for (char c = 0; c < R; ++c) {
            path.append(c);
            // enter
            traverse(node.children[c], path, result);
            // exit
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    private TrieNode getNode(TrieNode node, String key) {
        // search key from node(downwards)
        TrieNode p = node;
        
        for (int i = 0; i < key.length(); ++i) {
            if (p == null) {
                return null;
            }
            
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }
    
    public Integer get(String key) {
        TrieNode x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }
    
    public boolean hasPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }
    
    
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */