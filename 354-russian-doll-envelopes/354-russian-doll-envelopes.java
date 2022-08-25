class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort based on: weight ascending then height descending
        // 因为宽度相同根据题设不能套娃，所以高度排序要反过来，这样相同宽度不同高度的信封不能嵌套（一组w对应的h里只能选一个）
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] == arr2[0] ? 
                    arr2[1] - arr1[1] : arr1[0] - arr2[0];
            }
        });
        int[] heights = new int[n];
        for (int i = 0; i < n; ++i) {
            heights[i] = envelopes[i][1];
        }
        
        return lengthOfLIS(heights);
    }
    
    public int lengthOfLIS(int[] nums) {
        // patience sorting
        int pileCount = 0, n = nums.length;
        // top card on each pile
        int[] tops = new int[n]; // at most n piles
        
        // deal with each card
        for (int num : nums) {
            // find a place for each card by binary search
            // find left bound
            int left = 0, right = pileCount;
            // [left, right)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tops[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            if (left == pileCount) {
                // if no where to put the new card
                // new a pile
                ++pileCount;
            }
            // put the card on the searched left bound
            tops[left] = num;
        }
        // piles # is LIS
        return pileCount;
    }    
}