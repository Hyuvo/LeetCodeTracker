class WordDictionary {
    private final TrieMap<Object> map = new TrieMap<>();
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        // use key to store word, Object as placehoder
        map.put(word, new Object());
    }
    
    public boolean search(String word) {
        // has .
        return map.hasKeyWithPattern(word);
    }
}

class TrieMap<V> {
    private static final int R = 26;
    private int size = 0;
    private class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];        
    }
    private TrieNode<V> root = null;
    
    // methods
    
    public void put(String word, V val) {
        if (!containsKey(word)) {
            size++;
        }
        root = put(root, word, val, 0);
    }
    
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieNode<>();
        }
        if (i == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c - 'a'] = put(node.children[c - 'a'], key, val, i + 1);
        return node;        
    }
    
    public boolean hasKeyWithPattern(String pattern) {
        
        return hasKeyWithPattern(root, pattern, 0);
    }
    
    // recursion helper
    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        if (node == null) {
            // cannot continue
            return false;
        }
        if (i == pattern.length()) {
            // reaches the end
            return node.val != null;
        }
        
        char c = pattern.charAt(i);
        if (c != '.') {
            // if not .
            return hasKeyWithPattern(node.children[c - 'a'], pattern, i + 1);
        } 
            
        for (int j = 0; j < R; ++j) {
            // see every possible char, return if any has val
            if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                return true;
            }
            // return hasKeyWithPattern(node.children[j], pattern, i + 1);        
        }
        // nothing matched
        return false;
        
    }
    
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        // search downwards from node
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); ++i) {
            if (p == null) {
                return null;
            }
            
            char c = key.charAt(i);
            p = p.children[c - 'a'];
        }
        return p;        
    }
    
    private V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if(x == null || x.val == null) {
            return null;
        }
        return x.val;
    }
    
    private boolean containsKey(String key) {
        return get(key) != null;        
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */