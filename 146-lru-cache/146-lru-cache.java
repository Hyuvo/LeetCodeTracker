class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        makeRecent(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        } else {
            if (cache.size() >= capacity) {
                int eldestKey = cache.keySet().iterator().next(); 
                cache.remove(eldestKey);
            }
            cache.put(key, value);
            makeRecent(key);
        }
        
    }
    
    public void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        // add to the end of the list
        cache.put(key, val);
       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// class LRUCache {
//     private int capacity;
//     private DoubleList cache;
//     private HashMap<Integer, Node> map;
    
//     public void makeRecent(int key) {
//         Node x = map.get(key);
//         // swap to the last
//         cache.remove(x);
//         cache.addLast(x);
//     }
//     public void addRecent(int key, int val) {
//         Node x = new Node(key, val);
//         cache.addLast(x);
//         map.put(key, x);
//     }
    
//     public void deleteKey(int key) {
//         Node x = map.get(key);
//         cache.remove(x);
//         map.remove(key);
//     }
    
//     public void removeLeastRecent() {
//         Node first = cache.removeFirst();
//         map.remove(first.key);
//     }
    
//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         cache = new DoubleList();
//         map = new HashMap<>();
//     }
    
//     public int get(int key) {
//         if (!map.containsKey(key)) {
//             return -1;
//         }
//         makeRecent(key);
//         return map.get(key).val;
//     }
    
//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             deleteKey(key);
//             addRecent(key, value);
//             return;
//         } 
//         // if not contains key
//         if (cache.getSize() == capacity) {
//             removeLeastRecent();
//         }
//         addRecent(key, value);
//         return;
//     }
    
    
//     class Node {
//         private int key, val;
//         private Node prev, next;
        
//         public Node(int key, int val) {
//             this.key = key;
//             this.val = val;
            
//         }        
//     }
    
//     class DoubleList {
//         private Node head, tail;
//         private int size;
        
//         public DoubleList() {
//             this.size = 0;
//             this.head = new Node(0, 0);
//             this.tail = new Node(0, 0);
//             head.next = tail;
//             tail.prev = head;
//         }
        
//         // most recent node at the end of the list
//         public void addLast(Node x) {
//             x.prev = tail.prev;
//             x.next = tail;
//             tail.prev.next = x;
//             tail.prev = x;
//             size++;
//         }
        
        
//         public void remove(Node x) {
//             x.prev.next = x.next;
//             x.next.prev = x.prev;
//             size--;
//         }
        
        
//         public Node removeFirst() {
//             if (size == 0) {
//                 return null;
//             }
//             Node first = head.next;
//             remove(first);
            
//             return first;
            
//         }
        
//         public int getSize() {
//             return size;
//         }
//     }


// }
