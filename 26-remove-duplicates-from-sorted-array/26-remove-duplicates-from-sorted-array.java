class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                // make sure the first k numbers shoud be unique
                //if fast detects new number
                //move slow forward and store the new number
                nums[++slow] = nums[fast];                
            }
            ++fast;
        }
        return slow+1;
    }
}