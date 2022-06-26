class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }
    
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                right = mid - 1;
                // to approach left bound
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // check if out of bound
        return (left >= nums.length || nums[left] != target)? -1 : left;
    }
    
    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                left = mid + 1;
                // to approach left bound
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }            
        }
        // check if out of bound
        return (right < 0 || nums[right] != target)? -1 : right;
    }
}