class Trie {
    // use trie map, word is the key, count is the value
    private TrieMap<Integer> map = new TrieMap<>();
    public Trie() {
       
    }
    
    public void insert(String word) {
        if (!map.containsKey(word)) {
            map.put(word, 1);
        } else {
            map.put(word, map.get(word) + 1);
        }
    }
    
    public int countWordsEqualTo(String word) {
        
        if (!map.containsKey(word)) {
            return 0;
        }
        return map.get(word);
    }
    
    public int countWordsStartingWith(String prefix) {
        
        int result = 0;
        for (String word : map.keysWithPrefix(prefix)) {
            result += map.get(word);
        }
        return result;
    }
    
    // this is so misleading
    // erase means deducte 1 count
    public void erase(String word) {
        int freq = map.get(word);
        if (freq - 1 == 0) {
            map.remove(word);
        } else {
            map.put(word, map.get(word) - 1);
        }
    }
}

class TrieMap<V> {
    private static final int R = 256; // all lowercase
    private int size = 0;
    private class TrieNode<V> {
        V val;
        TrieNode<V>[] children = new TrieNode[R];           
    }
    private TrieNode root = null;
    
    // methods
    
    
    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        
        this.root = put(root, key, val, 0);
    }
    
    private TrieNode put(TrieNode node, String key, V val, int i) {
        // recursively attach node along the path
        if (node == null) {
            node = new TrieNode();
        }
        if (i == key.length()) {
            // reaches the des, set value
            node.val = val;
            return node;
        }
        
        // recursion
        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }
    
    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }
    
    public List<String> keysWithPrefix(String prefix) {
        List<String> result = new LinkedList<>();
        // search from the node with the prefix
        TrieNode node = getNode(root, prefix);
        if (node == null) {
            // no such prefix
            return result;
        }
        // already has a prefix!
        StringBuilder path = new StringBuilder(prefix);
        traverse(node, path, result);
        return result;
    }
    
    private void traverse(TrieNode node, StringBuilder path, List<String> result) {
        TrieNode p = node;
        if (p == null) {
            return;
        }
        if (p.val != null) {
            result.add(path.toString());
        }
        // traversal
        for (char c = 0; c < R; ++c) {      
            // enter 
            path.append(c);
            traverse(node.children[c], path, result);
            // exit
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        this.root = remove(root, key, 0);
        size--;
        
    }
    
    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        // recursively remove node and return deleted node
        if (node == null) {
            // have to stop
            return null;
        }
        if (i == key.length()) {
            // reaches des
            // empty the val
            node.val = null;
        } else {
            // go to subtree
            char c = key.charAt(i);
            node.children[c] = remove(node.children[c], key, i + 1);           
        }
        
        // postorder, check if the subtree need to be trimmed
        
        // if the node has val, keep the node
        if (node.val != null) {
            return node;
        }
        // if the node has non-empty subtree, keep the node
        for (char c = 0; c < R; ++c) {
            // as long as a child is non-empty
            if (node.children[c] != null) {
                return node;
            }
        }
        
        // reaching here means the node has no val and no non-empty subtree
        // need to be trimmed
        return null;                
    }
    
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        //search downwards from node
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); ++i) {
            if (p == null) {
                // no node exists, path broken
                return null;
            }
            char c = key.charAt(i);
            p = p.children[c];
            
        }
        return p;
    }
    
    public boolean containsKey(String key) {
        return get(key) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */