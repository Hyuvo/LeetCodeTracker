class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1000];
        Difference diff = new Difference(locations);
        for (int[] trip : trips) {
            // the psg would already be off at trip[2]
            // so the psg would be on in [trip[1], trip[2] - 1]
            diff.increment(trip[1], trip[2] - 1, trip[0]);
        }
        for (int count : diff.result()) {
            if (count > capacity) {
                return false;
            }
        }
        return true;
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
    
    public void increment(int from, int to, int val) {
        diff[from] += val;
        if (to + 1 < diff.length) {
            diff[to + 1] -= val;
        }
    }
    
    public int[] result() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; ++i) {
            result[i] = diff[i] + result[i - 1];
        }
        return result;
    }
}