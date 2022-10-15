class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        // sort based on end
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // init the end with the 1st interval
        int end = points[0][1];
        int count = 1;
        for (int[] point : points) {
            int start = point[0];
            // cannot shoot with current arrow
            if (start > end) {
                count++;
                // move and shoot another one
                end = point[1];
            }
        }
        return count;
    }
}