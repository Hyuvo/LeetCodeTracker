class Solution {
    private HashMap<Integer, Integer> mapping;
    private Random random;
    private int size;
    
    public Solution(int n, int[] blacklist) {
        mapping = new HashMap();
        random = new Random();
        size = n - blacklist.length;
        
        for (int black: blacklist) {
            mapping.put(black, 666);
        }
        
        int last = n - 1;
        for (int black: blacklist) {
            // if last is already at the end of the range, continue
            if (black > size - 1) {
                continue;
            }
            // if last should be blocked, move pointer
            while(mapping.containsKey(last)) {
                last--;
            }
            // point black to the end of the range
            mapping.put(black, last);
            last--;
        }
        
    }
    
    public int pick() {
        // pick an index within[0, size - 1]
        // Note: int nxt = ran.nextInt(10); Returns number between 0-9
        int index = random.nextInt(size);
        return mapping.containsKey(index) ? mapping.get(index) : index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */