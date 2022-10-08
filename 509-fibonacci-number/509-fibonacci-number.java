class Solution {
    public int fib(int n) {
        // base case
        if (n == 0 || n == 1) return n;
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; ++i) {
            int dp_i = dp_i_1 + dp_i_2;
            // update on a rolling basis
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}

// class Solution {
//     // bottom up
//     public int fib(int n) {
//         if (n == 0) return 0;        
//         int[] memo = new int[n + 1];
//         memo[0] = 0;
//         memo[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             memo[i] = memo[i - 1] + memo[i - 2];
//         }
//         return memo[n];
//     }
// }

// class Solution {
//     // top down
//     public int fib(int n) {
//         int[] memo = new int[n + 1];
//         return helper(memo, n);
//     }
    
//     private int helper(int[] memo, int n) {
//         if (n == 0 || n == 1) return n;
//         if (memo[n] != 0) return memo[n];
        
//         memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
//         return memo[n];
//     }
// }