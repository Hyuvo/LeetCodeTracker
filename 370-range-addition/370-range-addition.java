class Solution {
    
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference diff = new Difference(nums);
        for (int[] update : updates) {
            diff.increment(update[0], update[1], update[2]);
        }
        return diff.result();
    }
}

class Difference {
    private int[] diff;
    
    public Difference(int[] nums) {
        int n = nums.length;
        diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    
    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < diff.length) {
            diff[end + 1] -= val;
        }
    }
    
    public int[] result() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; ++i) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}