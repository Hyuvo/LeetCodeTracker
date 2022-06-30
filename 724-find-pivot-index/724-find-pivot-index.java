class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i = 1; i < preSum.length; ++i) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        
        for(int i = 1; i < preSum.length; ++i) {
            if(preSum[i - 1] == preSum[preSum.length - 1] - preSum[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
// int left = 0, right = preSum.length - 1;
        // while(left <= right) {
        //     int pivot = left + (right - left) / 2;
        //     if(preSum[pivot - 1] == preSum[preSum.length - 1] - preSum[pivot]) {
        //         right = pivot - 1;
        //     } else if (preSum[pivot - 1] < preSum[preSum.length - 1] - preSum[pivot]){
        //         left = pivot + 1;
        //     } else if (preSum[pivot - 1] > preSum[preSum.length - 1] - preSum[pivot]) {
        //         right = pivot - 1;
        //     }
        // 