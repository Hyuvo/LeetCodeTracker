class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        int used = 0;
        
        return backtrack(k, 0, nums, 0, target, used);            
    }
    
    HashMap<Integer, Boolean> memo = new HashMap();
    // put from bucket's pov, k buckets to be filled
    public boolean backtrack(int k, int bucket, int[] nums, int start, int target, int used) {
        if (k == 0) {
            // filled all buckets
            return true;
        }
        
        // if complete the current bucket
        if (bucket == target) {
            // move to the next bucket
            boolean result = backtrack(k - 1, 0, nums, 0, target, used);
            memo.put(used, result);
            return result;
        }
        
        // if memoed this bucket filling plan
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        
        for (int i = start; i < nums.length; ++i) {
            // if the num is used[i]
            // already in other bucket
            if (((used >> i) & 1) == 1) {
                continue;
            }
            // current num cannot fit
            if (bucket + nums[i] > target) {
                continue;
            }
            
            // set current num used
            used |= 1 << i;
            // put current num in the bucket
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, target, used)) {
                return true;
            }
            // withdraw
            used ^= 1 << i;
            bucket -= nums[i];
            
        }
        return false;
    }
    
    
}