class Solution {
    public int[][] generateMatrix(int n) {
        int[][] resMatrix = new int[n][n];
        //init boundaries
        int left = 0, right = n - 1, upper = 0, lower = n - 1;
        int num = 1;
        while(num <= n*n) {
            if(upper <= lower) {
                for(int j = left; j <= right; ++j) {
                    resMatrix[upper][j] = num++;
                }
                upper++;
            }
            if(right >= left) {
                for(int j = upper; j <= lower; ++j) {
                    resMatrix[j][right] = num++;
                }
                right--;
            }
            if(lower >= upper) {
                for(int j = right; j >= left; --j) {
                    resMatrix[lower][j] = num++;
                }
                lower--;
            }
            if(left <= right) {
                for(int j = lower; j >= upper; --j) {
                    resMatrix[j][left] = num++;
                }
                left++;
            }            
        }
        return resMatrix;
    }
}