class Solution {
    // top down
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }
    
    private int helper(int[] memo, int n) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}