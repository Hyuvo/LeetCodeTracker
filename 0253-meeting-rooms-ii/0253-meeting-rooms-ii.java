class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        // store and sort starts and ends respectively
        for (int i = 0; i < n; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        // use 2 pointers to track start and end respectively
        // and track the max rooms needed at the same time
        int room = 0, count = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // if encounters a start, need 1 more room
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                // encounters an end, need 1 less room
                count--;
                j++;
            }
            room = Math.max(room, count);
        }
        return room;
    }
}

// class Solution {
//     // greedy cannot pass
//     public int minMeetingRooms(int[][] intervals) {
//         // sort by ends O(nlogn)
//         Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
//         // 2 pointers
//         int left = 0, right = 1;
//         int room = 1;
//         while (right < intervals.length) {
//             // add new room only when current meeting conflicts with next meeting
//             if (intervals[left][1] > intervals[right][0]) {
//                 room++;
//                 // move to next meeting
//                 right++;
//             } else {
//                 // no conflict, continue meeting
//                 // update current meeting
//                 left = right++;
//             }
//         }
        
//         return room;
            
//     }
// }