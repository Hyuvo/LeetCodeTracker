class Solution {
    public void rotate(int[][] matrix) {
        //first mirror the matrix
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = i; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //then reverse the matrix
        for(int i = 0; i < matrix.length; ++i) {
            reverse(matrix[i]);
        }
        
        // for (int[] row: matrix) {
        //     reverse(row);
        // }
        
    }
    
    public void reverse(int[] array) {
        int i = 0, j = array.length - 1;
        while(i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            ++i;
            --j;
        }
    }
}