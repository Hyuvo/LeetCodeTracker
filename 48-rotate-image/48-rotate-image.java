class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // first flip by the diangle
        for (int i = 0; i < m; ++i) {
            // j start from i, cuz 0 ~ i - 1 have already been taken care of
            for (int j = i; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // then reverse vertically;
        for (int[] row : matrix) {
            reverse(row);
        }
        
    }
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }
             
    }
}