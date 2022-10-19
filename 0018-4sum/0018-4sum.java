class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, target, 0);
    }
    public List<List<Integer>> nSum(int[] nums, int n, long target, int start) {
        int size = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        
        // make sure at least 2 sum and array len should > n of sum
        if (n < 2 || size < n) return result;
        
        // 2 sum as base case
        if (n == 2) {
            int low = start, high = size - 1;
            while (low < high) {
                int left = nums[low], right = nums[high];
                long sum = left + right;
                if (sum < target) {
                    while (low < high && left == nums[low]) low++;
                } else if (sum > target) {
                 while (low < high && right == nums[high]) high--;
                } else {
                    // sum == target
                    result.add(new LinkedList<>(List.of(left, right)));
                    while (low < high && left == nums[low]) low++;
                    while (low < high && right == nums[high]) high--;
                }  
            }          
            return result;
        } else {
            // n > 2
            for (int i = start; i < nums.length; ++i) {
                List<List<Integer>> temp = nSum(nums, n - 1, target - nums[i], i + 1);
                for (List<Integer> list : temp) {
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) i++; 
            }
        }
        
        return result;
    }
 
}

