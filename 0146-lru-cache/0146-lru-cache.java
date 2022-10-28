class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    DoubleList cache;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap();
        cache = new DoubleList();
    }
    
    public void addRecent(int key, int val) {
        Node x = new Node(key, val);
        map.put(key, x);
        cache.addLast(x);
    }
    
    public void removeKey(int key) {
        Node x = map.get(key);
        map.remove(key);
        cache.remove(x);
    }
    
    public void makeRecent(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    
    public void removeLeastRecent() {
        Node first = cache.removeFirst();
        map.remove(first.key);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        // if map contains key, update it 
        if (map.containsKey(key)) {
            removeKey(key);
            addRecent(key, value);
            // NOTE: return !!!!!
            return;
        }
        // if no such key, check cap and put
        // if cache is full, remove least recent
        if (cap == cache.size()) {
            removeLeastRecent();
        }
        addRecent(key, value);
    }
}

class Node {
    public int key, val;
    public Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private int size;
    private Node head, tail;
    public DoubleList() {
        size = 0;
        // dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addLast(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;  
        size++;
    }
    // key must exist
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    
    public int size() {return size;}
    
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */