class Solution {
    private int lower, upper, count = 0;
    private long[] temp;
    // count S(i, j) \in [lower, upper]
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        // S[i,j] should be within [lower, upper]
        this.lower = lower;
        this.upper = upper;
        long[] preSum = new long[nums.length + 1];
        // preSum[i] is sum(nums[0], nums[i - 1]) 
        // (sum of ele index prior to i)
        for (int i = 0; i < nums.length; ++i) {
            preSum[i + 1] = preSum[i] + (long) nums[i];
        }
        sort(preSum);
        return count;
    }
    
    public void sort(long[] preSum) {
        temp = new long[preSum.length];
        sort(preSum, 0, preSum.length - 1);        
    }
    
    public void sort(long[] preSum, int low, int up) {
        //[low, up] for sorting
        if (low == up) return;    
        
        int mid = low + (up - low) / 2;
        
        sort(preSum, low, mid);
        sort(preSum, mid + 1, up);
        merge(preSum, low, mid, up);
    }
    
    public void merge(long[] preSum, int low, int mid, int up) {
        // store initial order in temp
        for (int i = low; i <= up; ++i) {
            temp[i] = preSum[i];
        }
        // priort to merging 2 SORTED arrays
        // count the # of S[i, j] in range [lower, upper], where S = preSum[j + 1] - preSum[i]
        // so need to maintain an interval [start, end)
        // s.t. for each i in [low, mid], each indice x in [start, end) meets preSum[x] - preSum[i], i.e S[i, x], in [lower, upper]
        // as i increases, the [start, end) only moves non-decreasingly
        // the # of x for each i (i.e end - start) adds up to final result count
        int start = mid + 1, end = mid + 1;
        for(int i = low; i <= mid; ++i) {
            // sort of like a sliding window
            while(start <= up && preSum[start] - preSum[i] < lower) {
                start++;
            }
            // as end is excluded
            while(end <= up && preSum[end] - preSum[i] <= upper) {
                end++;
            }
            count += end - start;
        }
        
        // now merge the 2 halves of the array
        int m = low, n = mid + 1;
        for(int p = low; p <= up; ++p) {
            // when m reaches the end
            if (m == mid + 1) {
                preSum[p] = temp[n++];
            } else if (n == up + 1) { // when n reaches the end
                preSum[p] = temp[m++];
            } else if (temp[m] <= temp[n]) {
                preSum[p] = temp[m++];
            } else {
                preSum[p] = temp[n++];
            }
        }
    }
}