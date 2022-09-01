class Node {
    public int key, val;
    public Node prev, next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;  
    }
}

class DoubleList {
    private Node head, tail;
    private int size;
    
    public DoubleList() {
        // dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // connect head and tail for empty list
        head.next = tail;
        tail.prev = head;
    }
    
    // regard the head of list as least recent and the tail as most recent
    
    // when adding, put new node to the end of the list
    public void addLast(Node x) {        
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        ++size;
    }
    // need remove a node in O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        --size;
    }
    
    // when reach cap of chache, remove head of the list and return deleted node
    public Node removeFirst() {
        // check if empty list
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    
    public int size() {
        return size;
    }
}

class LRUCache {
    // combine hash and double list to meet get by key and put pair in O(1)
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        cap = capacity;
    }
    
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        makeRecent(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        // if key already exists, update and make recent
        if (map.containsKey(key)) {
            // remove old
            deleteKey(key);
            // add new
            addRecent(key, value);
            
        } else {
            // if does not exist, check if reaches cap, then add
            if (cap == cache.size()) {
                removeLeastRecent();
            }
            addRecent(key, value);
        }
    }
    // provide higher level operation combining map and cache
    private void makeRecent(int key) {
        Node x = map.get(key);
        // remove and add to the end
        cache.remove(x);
        cache.addLast(x);
    }
    
    // add or update
    private void addRecent(int key, int val) {
        Node x = new Node(key, val);
        map.put(key, x);
        cache.addLast(x);
    }
    
    // delete a key
    private void deleteKey(int key) {
        Node deleted = map.get(key);
        cache.remove(deleted);
        map.remove(key);
    }
    
    // remove leaset recently used key
    private void removeLeastRecent() {
        Node leastRecent = cache.removeFirst();
        map.remove(leastRecent.key);        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */