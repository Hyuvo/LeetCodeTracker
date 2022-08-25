class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxAmount = 0;
        while (left < right) {
            maxAmount = Math.max(maxAmount,
                                Math.min(height[left], height[right]) * (right - left));
            // move the lower side, as you can only get a possibly larger area by increasing the hight while shrinking the width
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        
        return maxAmount;
    }
}