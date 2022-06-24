class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);
        // n flights in bookings starts from 1
        for(int[] booking: bookings) {
            // flight to index: -1
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];
            diff.increment(first, last, seats);
        }
        
        return diff.result();
    }
    
    class Difference{
        private int[] diff;
        
        public Difference(int[] nums) {
            assert nums.length > 0;
            this.diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                diff[i] = nums[i] - nums[i-1];
            }            
        }
        
        public void increment(int start, int end, int value) {
            diff[start] += value;
            if(end < diff.length - 1) {
                diff[end + 1] -= value;
            }
        }
        
        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for(int i = 1; i < diff.length; ++i) {
                result[i] = result[i-1] + diff[i];
            }
            return result;
        }
    }
}