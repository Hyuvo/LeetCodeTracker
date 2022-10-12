class Solution {    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
        
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] image, int i, int j, int old, int color) {
        int m = image.length, n = image[0].length;
        // validate (i, j)
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        // color not match
        if (image[i][j] != old) return;
        // if already has new color
        if (image[i][j] == color) return;
        // replace with new color
        image[i][j] = color;
        // traverse to neighbors
        for (int[] dir : directions) {
            dfs(image, i + dir[0], j + dir[1], old, color);
        }
            
    }
}