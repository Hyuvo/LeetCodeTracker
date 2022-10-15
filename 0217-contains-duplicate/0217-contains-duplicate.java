class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > 1) return true;
        }
        return false;
    }
}