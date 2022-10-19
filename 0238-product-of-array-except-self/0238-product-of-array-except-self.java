class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n], R = new int[n];
        // feels like presum -> pre product
        L[0] = 1;
        for (int i = 1; i < n; ++i) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            R[i] = R[i + 1] * nums[i + 1];
           
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
    
}