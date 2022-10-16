class Solution {
    //intervals sorted in ascending order by starti
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int index = 0, n = intervals.length;
        LinkedList<int[]> result = new LinkedList();
        
        // add intervals starting before new start to result
        while (index < n && intervals[index][0] < newStart) {
            result.add(intervals[index++]);
        }
        
        // add the new interval
        
        // if no overlap with the last added one, just add it
        if (result.isEmpty() || result.getLast()[1] < newStart) {
            result.add(newInterval);
        } else {
            // if overlaps, update the new interval (merge)
            int[] interval = result.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            result.add(interval);
        }
        
        // add the rest of the intervals to the result
        // merge if needed
        while (index < n) {
            int[] interval = intervals[index++];
            int start = interval[0], end = interval[1];
            // if no overlap, add
            if (result.getLast()[1] < start) {
                result.add(interval);
            } else {
                // if overlaps, update interval end
                interval = result.removeLast();
                interval[1] = Math.max(end, interval[1]);
                result.add(interval);
            }
        }
        // need to new space
        return result.toArray(new int[result.size()][2]);
        
    }
}