class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }
    
    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left >= nums.length || nums[left] != target) ? -1 : left;
    }
    
    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (right < 0 || nums[right] != target) ? -1 : right;
    }
}