class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.get(num) > nums.length / 2) {
                return num;
            }
        }
        // must exist
        return 0;
    }
}