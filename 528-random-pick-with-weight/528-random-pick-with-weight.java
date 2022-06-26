class Solution {
    private int[] preSum;
    private Random rand = new Random();

    public Solution(int[] w) {
        preSum = new int[w.length + 1];
        preSum[0] = 0;
        for(int i = 1; i <= w.length; ++i) {
            preSum[i] = preSum[i-1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        // int target = (int) Math.random() * preSum[preSum.length - 1] + 1;
        int target = rand.nextInt(preSum[preSum.length - 1]) + 1;
        
        return leftBound(preSum, target) - 1; 
    }
    
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
//         left >= nums.length || nums[left] != target
        return (nums.length == 0) ? -1 : left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */