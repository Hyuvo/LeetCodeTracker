class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // put the dict in a trie set and use the shortestPrefixOf method
        TrieSet dict = new TrieSet();
        for (String root : dictionary) {
            dict.add(root);
        }
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            String prefix = dict.shortestPrefixOf(words[i]);
            // if prefix can be found, replace
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
            
        }        

        return String.join(" ", words);
    }
}

class TrieSet {
    private final TrieMap<Object> map = new TrieMap<>();
    
    // methods
    public void add(String key) {
        // use key to store, val is a placeholder
        map.put(key, new Object());
    }
    
    public String shortestPrefixOf(String query) {
        return map.shortestPrefixOf(query);
    }
    
    
}

class TrieMap<V> {
    private static final int R = 256;
    private int size = 0;
    private class TrieNode<V> {
        V val;
        TrieNode<V>[] children = new TrieNode[R];
    }
    private TrieNode root = null;
    
    // methods
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
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
        if (root == null || root.val == null) {
            // not a key
            return null;
        }
        return x.val;
    }
    
    public boolean containsKey(String key) {
        // a valid key
        return get(key) != null;
    }
    
    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }
    
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        // recursively attach node along path char by char
        if (node == null) {
            node = new TrieNode<V>();
        }
        if (i == key.length()) {
            // reach the target index, put the val
            node.val = val;
            return node;            
        }
        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
        
        
    }
    
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); ++i) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                // shortest prefix is the 1st find non-empty value node
                return query.substring(0, i);
            }
            
            char c = query.charAt(i);
            p = p.children[c];            
        }
        
        // search till the last char
        // see if the query itself is a key
        if (p != null && p.val != null) {
            return query;
        }
        return "";
    }
 }