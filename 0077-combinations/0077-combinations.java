class Solution {
    // C(n, k) is the subset of k size
    List<List<Integer>> result = new LinkedList();
    LinkedList<Integer> track = new LinkedList();
    public List<List<Integer>> combine(int n, int k) {
        // 1-indexed
        backtrack(n, 1, k);
        return result;
    }
    
    public void backtrack(int n, int start, int k) {
        if (track.size() == k) {
            result.add(new LinkedList(track));
        }
        
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1, k);
            track.removeLast();
        }
    }
}