class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        // 3 pointers
        int p1 = 0, p2 = n - 1, curr = 0;
        // p1 for rightmost bound of 0, p2 for leftmost bound of 2
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // encounter1
                // swap curr with p1
                swap(nums, curr++, p1++); 
                // 因为遇到0交换之后到前面的一定是1，所以cur++
            } else if (nums[curr] == 2) {
                // encounter 2
                // swap curr with p2
                // NOTE: curr do not move forward
                swap(nums, curr, p2--);
                // 但是遇到2交换过来的不知道是啥，所以cur不能动，还要再看
            } else curr++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}