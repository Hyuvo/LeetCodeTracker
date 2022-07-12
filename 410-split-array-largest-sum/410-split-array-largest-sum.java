class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            //subSum >= max{nums}
            left = Math.max(num, left);
            //subSum <= Sum{nums}
            right += num;
        }
        while (left <= right) { //search m within [left, right]
            int mid = left + (right - left) / 2;
            if (countGroup(nums, mid) == m) {
                // search left bound
                right = mid - 1;
            } else if (countGroup(nums, mid) > m) {
                left = mid + 1;
            } else if (countGroup(nums, mid) < m) {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public int countGroup(int[] nums, int maxSum) {
        // maxSum decrease => groups increase
        int group = 1;
        int subSum = 0;
        for (int num : nums) {
            // if this num can be put in the current partition, put it
            if (subSum + num <= maxSum) {
                subSum += num;
            // if this num cannot be accomadated in the current partition,
            // put it in next partition(the first num in next partition)
            } else {
                group++;
                subSum = num;
            }
        }
        return group;
    }
    
//     public int countGroup(int[] nums, int maxSum) {
//         int group = 1;// number of partition        
//         for (int i = 0; i < nums.length;) {
//             int subsum = maxSum;
//             while(subsum < nums[i]) {
//                 if (subsum < nums[i]) {
//                     break;
//                 } else {
//                     subsum -= nums[i];
//                     ++i;
//                 }
                
//             }
//             group++;
//         }
//         return group;
//     }
    
    
}