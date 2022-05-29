// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         O(n^2)
//         int[] indices = new int[2];
//         for (int i = 0; i <  nums.length; ++i){
//             for (int j = i + 1; j < nums.length; ++j){
//                 if (nums[i] + nums[j] == target){
//                     indices[0] = i;
//                     indices[1] = j;     
//                     break;
//                 }                                
//             }
//         }        
//     return indices;
//     }
// }

// O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if (tracker.containsKey(target - nums[i])){
                return new int[]{tracker.get(target - nums[i]), i};
            }
            tracker.put(nums[i], i);
        }
        return new int[]{};
    }
}