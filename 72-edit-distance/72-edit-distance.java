class Solution {
    // bottom-up with a dp table
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i + 1][j + 1] is the min edit distance between s1[0...i] and s2[0...j]
        // 1 index shift
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }
        // build the table bottom-up
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(// insert after s1[i]
                                    dp[i][j - 1] + 1,
                                    // delete s1[i]
                                    dp[i - 1][j] + 1,
                                    // replace s1[i] with s2[j]
                                    dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

// class Solution {
//     // top-down with a memo
//     int[][] memo;
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();
//         memo = new int[m][n];
//         // init memo with -1
//         for (int[] row : memo) {
//             Arrays.fill(row, -1);
//         }
//         // start from the end of strings       
//         return dp(word1, m - 1, word2, n - 1);
//     }
    
//     // return the min edit distance between s1[0~i-1] and s2[0~ j - 1]
//     public int dp(String s1, int i, String s2, int j) {
//         // base case
//         // either index reaches the head
//         if (i == -1) return j + 1;
//         if (j == -1) return i + 1;
//         // check the memo to reduce time
//         if (memo[i][j] != -1) return memo[i][j];
        
//         if (s1.charAt(i) == s2.charAt(j)) {
//             // if the same char, do nothing
//             memo[i][j] = dp(s1, i - 1, s2, j - 1);
//         } else {
//             // if s1[i] != s2[j]
//             memo[i][j] = min(
//                             // insert at s1[i], j moves forward
//                             dp(s1, i, s2, j - 1) + 1,
//                             // delete s1[i], i moves forward
//                             dp(s1, i - 1, s2, j) + 1,
//                             // replace s1[i] with s2[j], both move forward
//                             dp(s1, i - 1, s2, j - 1) + 1
//             );
//         }
//         return memo[i][j];
//     }
    
//     public int min(int a, int b, int c) {
//         int result = a;
//         result = Math.min(result, b);
//         result = Math.min(result, c);
//         return result;
//     }
// }