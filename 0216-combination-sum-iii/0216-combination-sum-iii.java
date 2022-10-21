class Solution {
    // K sum
    public List<List<Integer>> combinationSum3(int k, int n) {
        // int[] nums = new int[9];
        // for (int i = 1; i <= 9; ++i) {
        //     nums[i - 1] = i;
        // }
        // return nSum(nums, k, n, 0);
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
//     public List<List<Integer>> nSum(int[] nums, int n, long target, int start) {
//         int size = nums.length;
//         List<List<Integer>> result = new LinkedList<>();
        
//         // make sure at least 2 sum and array len should > n of sum
//         if (n < 2 || size < n) return result;
        
//         // 2 sum as base case
//         if (n == 2) {
//             int low = start, high = size - 1;
//             while (low < high) {
//                 int left = nums[low], right = nums[high];
//                 long sum = left + right;
//                 if (sum < target) {
//                     low++;
//                 } else if (sum > target) {
//                     high--;
//                 } else {
//                     // sum == target
//                     result.add(new LinkedList<>(List.of(left, right)));
//                     while (low < high && left == nums[low]) low++;
//                     while (low < high && right == nums[high]) high--;
//                 }  
//             }          
//             return result;
//         } else {
//             // n > 2
//             for (int i = start; i < nums.length; ++i) {
//                 List<List<Integer>> temp = nSum(nums, n - 1, target - nums[i], i + 1);
//                 for (List<Integer> list : temp) {
//                     list.add(nums[i]);
//                     result.add(list);
//                 }
//                 while (i < size - 1 && nums[i] == nums[i + 1]) i++; 
//             }
//         }
        
//         return result;
//     }
}
    
    

    
    