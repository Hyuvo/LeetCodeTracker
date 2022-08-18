class LFUCache {
    private int capacity;
    private int minFreq;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFreq;
    // use an ordered set to track the eldest key
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKey;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyToVal.containsKey(key)) {                      
            keyToVal.put(key, value);
            increaseFreq(key); 
            return;          
        }
        // if not contains this key
        // see if reach the cap
        if (keyToVal.size() >= capacity) {
            // remove the least freq key
            removeLeastFreqKey();
        }
        // add new key with freq 1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKey.putIfAbsent(1, new LinkedHashSet<Integer>());
        freqToKey.get(1).add(key);
        // maintain min freq, has to be 1 with the new key
        this.minFreq = 1;
    }
    
    public void increaseFreq(int key) {
        // maintain keyToFreq, FreqToKey
        int oldFreq = keyToFreq.get(key);
        keyToFreq.put(key, oldFreq + 1);
        // remove key from old freq and put it in updated freq
        freqToKey.get(oldFreq).remove(key);
        freqToKey.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
        freqToKey.get(oldFreq + 1).add(key);
        // if the old freq key set is empty, remove it
        if (freqToKey.get(oldFreq).isEmpty()) {
            freqToKey.remove(oldFreq);
            // if the old freq happens to be the min freq, update the minfreq
            if (oldFreq == minFreq) {
                this.minFreq++;
            }
        }
    }
    
    public void removeLeastFreqKey() {
        // this will be invoked when the cache reaches the cap
        // need to maintain keyToVal, keyToFreq, freqToKey
        // see which key to remove (head of the set)
        int keyToRemove = freqToKey.get(this.minFreq).iterator().next();
        keyToVal.remove(keyToRemove);
        keyToFreq.remove(keyToRemove);
        
        freqToKey.get(minFreq).remove(keyToRemove);
        // if the least freq key set is empty, remove it
        if (freqToKey.get(minFreq).isEmpty()) {
            freqToKey.remove(minFreq);
            // no need to take care of minFreq
            // as this method would only be invoked when adding a new key
            // then the minFreq would be set to 1
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */