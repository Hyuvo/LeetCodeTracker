class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greaterElements = nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], greaterElements[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    
    // helper: get next greater ele for each ele
    private int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        // put inversely
        for (int i = n - 1; i >= 0; --i) {
            // pop every element smaller than current element
            while(!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            result[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return result;
    }
}