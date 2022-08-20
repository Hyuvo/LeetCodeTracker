class Trie {
    
    // use key to store, val is taken by placeholder
    private final TrieMap<Object> map = new TrieMap<>();
    
    public Trie() {
        
    }
        
    public void insert(String word) {
        map.put(word, new Object());
    }
    
    public boolean search(String word) {
        return map.containsKey(word);
    }
    
    public boolean startsWith(String prefix) {
        return map.hasKeyWithPrefix(prefix);
    }
}


class TrieMap<V> {
    private static final int R = 256;
    private int size = 0;
    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }
    private TrieNode<V> root = null;
    
    // methods
    
    
    // search key from node
    private TrieNode<V> getNode(TrieNode node, String key) {
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); ++i) {
            if (p == null) {
                return null;
            }
        
            char c = key.charAt(i);
            p = p.children[c];
            
        }        
        return p;
    }
    
    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }
    
    
    public boolean containsKey(String key) {
        // if key has a value, then it's a key
        return get(key) != null;
    }
    
    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        
        root = put(root, key, val, 0);
    }
    
    // helper: recursively attach node char by char
    private TrieNode<V> put(TrieNode node, String key, V val, int i) {
        // create node on path
        if (node == null) {
            node = new TrieNode<V>();
        }
        // path built, place the val
        if (i == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }
    
    public boolean hasKeyWithPrefix(String prefix) {
        // don't need to have val, just need the path(prefix) exists
        return getNode(root, prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */