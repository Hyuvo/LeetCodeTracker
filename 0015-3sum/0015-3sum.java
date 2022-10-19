class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    
    private List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            // choose nums[i]
            // do 2-sum for target - nums[i]
            List<List<Integer>> temp = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> l : temp) {
                l.add(nums[i]);
                result.add(l);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
        
    }
    
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int low = start, high = nums.length - 1;
        List<List<Integer>> result = new LinkedList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target) {
                while (low < high && nums[low] == left) low++;
            } else if (sum > target) {
                while (low < high && nums[high] == right) high--;
            } else {
                result.add(new LinkedList<>(List.of(left, right)));
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return result;
    }
    
    
}