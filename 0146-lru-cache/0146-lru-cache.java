// node will be store in a list and map through hash
class Node {
    int key, val;
    Node next, prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    Node head, tail;
    int size;
    public DoubleList() {
        // dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    // regard head as least recent and tail as most recent
    
    public void addLast(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }
    
    // x must exist
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    
    // why return first? to add to tail
    public Node removeFirst() {
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
    int capacity;
    DoubleList list;
    HashMap<Integer, Node> keyToNode;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoubleList();
        keyToNode = new HashMap();
    }
    
    // remove first and add to tail
    public void makeRecent(int key) {
        Node x = keyToNode.get(key);
        list.remove(x);
        list.addLast(x);
    }
    
    public void addRecent(int key, int val) {
        Node x = new Node(key, val);
        keyToNode.put(key, x);
        list.addLast(x);
    }
    
    public void removeKey(int key) {
        Node x = keyToNode.get(key);
        keyToNode.remove(key);
        list.remove(x);
    }
    
    public void removeLeastRecent() {
        Node x = list.removeFirst();
        keyToNode.remove(x.key);
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return keyToNode.get(key).val;
    }
    
    public void put(int key, int value) {
        // if contains key, update
        if (keyToNode.containsKey(key)) {
            removeKey(key);
            addRecent(key, value);
            return;
        }
        // does not contain key
        // if reach cap, remove least recent
        if (list.size() == capacity) {
            removeLeastRecent();   
        }
        addRecent(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */