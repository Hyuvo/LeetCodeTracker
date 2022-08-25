class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        int n = nums.length;
        // preSum[i] = sum of first i nums; preSum[2] = nums[0] + nums[1]
        preSum = new int[n + 1];
        for (int i = 1; i < preSum.length; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        // sum[left, right] inclusive
        // sum(right + 1) - sum(left)
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */