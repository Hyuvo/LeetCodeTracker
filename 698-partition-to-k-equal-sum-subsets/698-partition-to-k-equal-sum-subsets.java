class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // boolean[] used = new boolean[nums.length];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        // using bitmasking
        int used = 0;
        return backtrack(k, 0, nums, 0, used, target);
    }
    // use memo to track each tested num combination/arrangement
    HashMap<Integer, Boolean> memo = new HashMap<>();
    
    public boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) {
            // all bucket are assigned nums
            // all nums must be assigned, as target = sum / k
            return true;
        }
        
        if (bucket == target) {
            // the current bucket is completed
            // fill next bucket
            boolean result = backtrack(k - 1, 0, nums, 0, used, target);
            // store the result
            memo.put(used, result);
        }
        
        // look up the memo to avoid duplicate computation
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        
        // fill with nums index from start
        for (int i = start; i < nums.length; ++i) {
            // cut branches
            if (((used >> i) & 1) == 1) {
                // if the ith num is used
                continue;
            }
            // if exceed current bucket
            if (bucket + nums[i] > target) {
                // got to next num
                continue;
            }
            
            // make a decision, put nums[i] into the bucket
            // used[i] = true;
            used |= 1 << i;
            bucket += nums[i];
            // see if next num can be put into current bucket
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            
            // withdraw the decision
            // used[i] = false;
            used ^= 1 << i;
            bucket -= nums[i];
            
            
        }
        return false;
    }
}