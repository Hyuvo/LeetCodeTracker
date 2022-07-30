class Solution {
    private int[] temp;
    private int count = 0;
    
    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }
    
    public void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }
    
    public void sort(int[] nums, int lower, int upper) {
         // base case
        if (lower == upper) return;
        
        int mid = lower + (upper - lower) / 2;
        
        sort(nums, lower, mid);
        sort(nums, mid + 1, upper);
        merge(nums, lower, mid, upper);
    }
    
    public void merge(int[] nums, int lower, int mid, int upper) {
        // copy initial nums to temp
        
        for (int i = lower; i <= upper; ++i) {
            temp[i] = nums[i];
        }
        
        // As these 2 half are sorted
        // for each nums[i], low <= i <= mid, the nums[j] s.t. nums[i] > 2*nums[j] will also make nums[i+1] > 2*nums[j]
        // only search j on the right half
        int end = mid + 1;// exclusive
        for (int i = lower; i < mid + 1; ++i) {
            while(end <= upper && (long) nums[i] > (long) nums[end] * 2) {
                end++;
            }
            count += end - (mid + 1);
        }
        
        // init i, j, p, pointing to the left half, righ half and sorted nums
        int i = lower, j = mid + 1;
        for (int p = lower; p <= upper; ++p) {
            // i reaches the end
            if (i == mid + 1) {
                nums[p] = temp[j++];
                // j reaches the end
            } else if (j == upper + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[p] = temp[i++];
            } else {
                nums[p] = temp[j++];
            }
        }
    }
}