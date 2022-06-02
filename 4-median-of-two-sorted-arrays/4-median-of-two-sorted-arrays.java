class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
        //     return 0.0;
        // }
        
        int m = nums1.length, n = nums2.length;
        
        int l = (m + n + 1) / 2; // the left part of the combined median
        int r = (m + n + 2) / 2; // the right part of the combined median
        // when m+n is odd, l = r, the median is an existing element in the array; 
        // when m+n is even, l != r, the median is the avg of 2 elements.
        
        double median = (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2;
        return median;
    }
    
    private double getKth (int[] nums1, int start1, int[] nums2, int start2, int k){
        // to get the Kth element of the merged array, recursively, until k == 1 is T
        
        // Basically, cut off k/2 elements from either array, in each iteration, until exhausts either one or k = 1. So the final iteration would be the stated 3 situations:
        
        // if nums1 is exhausted
        if (start1 > nums1.length - 1) return nums2[start2+k-1]; //don't forget start indice
        
        // if nums2 is exhausted
        if (start2 > nums2.length - 1) return nums1[start1+k-1];
        
        // if k == 1, and the arrays are sorted, the overall min is the smaller one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        // Next, need to determine the array with smaller median
        int median1 = Integer.MAX_VALUE;
        int median2 = Integer.MAX_VALUE;
        
        // if (the already-cut-off part length start -1) + (to-be-cut-off part len k/2) < original len, can be cut, then get medians
        if (start1 - 1 + k/2 < nums1.length) median1 = nums1[start1 + k/2 -1];
        
        if (start2 - 1 + k/2 < nums2.length) median2 = nums2[start2 + k/2 -1];
        
        // the array with smaller median (or generally the kth percentile element) is not containing the median of the merged array, and elements less than the median could be cut off 
        if (median1 < median2) {
            return getKth(nums1, start1 + k/2, nums2, start2, k-k/2); //nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k/2, k-k/2); //nums1 + nums2.right
        }
        // Throw away half of the array from nums1 or nums2. And cut k in half
    }
}