class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // init boundaries
        int m = matrix.length, n = matrix[0].length;
        int upper = 0, lower = m - 1, left = 0, right = n - 1;
        // init result list
        List<Integer> resList = new ArrayList<>();
        while(resList.size() < m*n) {
            if(upper <= lower) {
                for(int i = left; i <= right; ++i) {
                    resList.add(matrix[upper][i]);
                }
                upper++;
            }
            if(right >= left) {
                for(int i = upper; i <= lower; ++i) {
                    resList.add(matrix[i][right]);
                }
                right--;
            }
            if(lower >= upper) {
                for(int i = right; i >= left; i--) {
                    resList.add(matrix[lower][i]);
                }
                lower--;
            }
            if(left <= right) {
                for(int i = lower; i >= upper; i--) {
                    resList.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return resList;
    }
}