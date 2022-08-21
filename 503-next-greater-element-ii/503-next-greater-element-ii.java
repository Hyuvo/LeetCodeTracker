class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 循环数组用取余模拟
        int n = nums.length;
        int[] greater = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        // 2 round
        for (int i = 2 * n - 1; i >= 0; --i) {
            while(!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            greater[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        
        return greater;
    }
}