class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference diff = new Difference(nums);
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            diff.increment(start, end, value);
        }
        return diff.result();
    }
    
    class Difference{
        private int[] diff;
        
        public Difference(int[] nums) {
            assert nums.length > 0;
            this.diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; ++i) {
                //diff[i] is the difference btwn adjacent elements;
                diff[i] = nums[i] - nums[i-1];
            }
        }
        
        public void increment(int start, int end, int value) {
            // add value to num btwn [start, end]
            // add value to [start, diff.length - 1]
            diff[start] += value;
            // if end >= the last element of diff, then add value to all
            // ele >= start
            if(end < diff.length - 1) {
                diff[end + 1] -= value;
            }
        }
        
        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];
            //Based on diff[], recreate the result
            for(int i = 1; i < diff.length; ++i) {
                result[i] = result[i-1] + diff[i];
            }
            return result;
            
        }
    }
}