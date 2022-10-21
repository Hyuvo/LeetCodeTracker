class Solution {
    // K sum
    public List<List<Integer>> combinationSum3(int k, int n) {
        return kSum(k, n, 1);        
    }
    
        public List<List<Integer>> kSum(int k, int target, int start) {
        List<List<Integer>> result = new LinkedList();
        // if (k < 2 || 9 - start <= k) return result;
        if (k < 2) return result;
        // at least 2 sum
        if (k == 2) {
            int left = start, right = 9;
            while (left < right) {
                int sum = left + right;
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result.add(new LinkedList(List.of(left, right)));   
                    // Note: move left and right;
                    left++;
                    right--;
                }
            }
            return result;
        } else {
            // k > 2
            for (int i = start; i <= 9; ++i) {
                // choose i first, then find sum of target - i
                List<List<Integer>> temp = kSum(k - 1, target - i, i + 1);
                for (List<Integer> list : temp) {
                    list.add(i);
                    result.add(list);
                }
            }           
        }
        return result;
    }
}
    
    

    
    