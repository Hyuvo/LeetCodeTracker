class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                // descending for same starts
                // the wider interval need to be prior to the smaller one to be counted as cover
                return b[1] - a[1];          
            }
            return a[0] - b[0];
        });
        
        // init with the first interval
        int left = intervals[0][0], right = intervals[0][1];
        int result = 0;
        // count removed intervals
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            // 1. cover
            if (left <= cur[0] && right >= cur[1]) {
                // need to remove 1
                result++;
            }
            if (right > cur[0] && right <= cur[1]) {
                // merge
                right = cur[1];
            }
            if (right < cur[0]) {
                // update left and right
                left = cur[0];
                right = cur[1];
            }
        }
        return intervals.length - result;
    }
}