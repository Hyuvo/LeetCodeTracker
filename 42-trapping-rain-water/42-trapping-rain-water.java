class Solution {
    // two pointers, space O(1), time O(1)
    public int trap(int[] height) {
        // start from both ends
        int left = 0, right = height.length - 1;
        int sum = 0;
        int leftMax = 0, rightMax = 0;
        // cannot overlap
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);    
            
            if (leftMax < rightMax) {
                // do not care if rightMax is really right max of column left, as long as leftMax is less
                sum += leftMax - height[left];
                ++left;
            } else {
                sum += rightMax - height[right];
                --right;
            }
        }
        return sum;
    }
}
// class Solution {
//备忘录解法，l_max[i] 和 r_max[i] 分别代表 height[0..i] 和 height[i..end] 的最高柱子高度。
//     public int trap(int[] height) {
//         // space O(n) time O(1)
//         int n = height.length;
//         if (n == 0) return 0;
//         // leftMax[i] represents the max height to the left of i, inclusive
//         int[] leftMax = new int[n], rightMax = new int[n];
//         leftMax[0] = height[0];
//         rightMax[n - 1] = height[n - 1];
//         // move from right to left to maintain the rightMax
//         for (int i = n - 2; i >= 0; --i) {
//             rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//         }
//         // move from left to right to maintain the leftMax
//         for (int i = 1; i < n; ++i) {
//             leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//         }
//         int sum = 0;
//         // bounds cannot hold water
//         for (int i = 1; i < n - 1; ++i) {
//             sum += Math.min(leftMax[i], rightMax[i]) - height[i];
//         }
        
//         return sum;
//     }
// }