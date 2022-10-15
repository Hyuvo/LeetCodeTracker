class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // lambda expresion comparator
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; ++i) {
            int start = intervals[i][0];
            // if overlaps, count
            if (start < end) {
                count++;
            } else {
                // if no overlap, move forward
                end = intervals[i][1];
            }
        }
        return count;
    }
}