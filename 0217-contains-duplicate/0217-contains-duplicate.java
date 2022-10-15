class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashMap<Integer, Integer> count = new HashMap();
//         for (int num : nums) {
//             count.put(num, count.getOrDefault(num, 0) + 1);
//             if (count.get(num) > 1) return true;
//         }
//         return false;
//     }
// }