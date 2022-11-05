class Solution {
    // 分类讨论，用mid跟left比，可以得知左右哪边没断，然后在sub里搜
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                // the left part is ascending
                if (target >= nums[left] && target < nums[mid]) {
                    // target is at left
                    right = mid - 1;
                } else {
                    // target is at right
                    left = mid + 1;                    
                }
            } else {
                // the right part is ascending
                if (target > nums[mid] && target <= nums[right]) {
                    // target is at right
                    left = mid + 1;
                } else {
                    // target is at left
                    right = mid - 1;
                }
            }
        }        
        return -1;
    }
}