class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        return dp(n);
    }
    
    public int dp(int n) {
        if (n == 1 || n == 2) return n;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = dp(n - 1) + dp(n - 2);
        
        return memo[n];
    }
}