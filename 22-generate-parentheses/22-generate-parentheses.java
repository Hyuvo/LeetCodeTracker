class Solution {
    private List<String> result = new LinkedList<>();
    private StringBuilder track = new StringBuilder();
    
    public List<String> generateParenthesis(int n) {
        if (n == 0) return result;
        backtrack(n, n);
        return result;
    }
    
    public void backtrack(int left, int right) {
        // building valid parentheses pairs from left
        // # of '(' >= # of ')' to be valid
        if (right < left) return;
        
        // outta bound
        if (left < 0 || right < 0) return;
        // base case
        if (left == 0 && right == 0) {
            result.add(track.toString());
            return;
        }
        
        // try every combination
        // like traverse to left and right subtree
        track.append('(');
        backtrack(left - 1, right);
        track.deleteCharAt(track.length() - 1);
        
        track.append(')');
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }
}