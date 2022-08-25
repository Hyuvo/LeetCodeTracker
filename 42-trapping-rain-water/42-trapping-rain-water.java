class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        // leftMax[i] represents the max height to the left of i, inclusive
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        // move from right to left to maintain the rightMax
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // move from left to right to maintain the leftMax
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int sum = 0;
        // bounds cannot hold water
        for (int i = 1; i < n - 1; ++i) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return sum;
    }
}