class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            int[] last = result.getLast();
            // overlap with last interval
            if (last[1] >= cur[0]) {
                result.removeLast();
                last[1] = Math.max(last[1], cur[1]);
                result.add(last);
            } else {
                result.add(cur);
            }
        }
        
        return result.toArray(new int[0][0]);
    }
}