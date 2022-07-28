class Solution {
    
    class Pair {
        private int value;
        private int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
            
        }
    }
    
    private Pair[] temp; // the assist array
    private int[] count; // the result

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        
        for (int i = 0; i < n; ++i) {
            arr[i] = new Pair(nums[i], i);
        }
        
        sort(arr, 0, n-1);
        
       
        LinkedList<Integer> result = new LinkedList<>();
        for (int c : count) {
            result.add(c);
        } 
        
        return result;
        
    }
    
    public void sort(Pair[] arr, int low, int high) {
        // base case
        if (low == high) return;
        int mid = low + (high - low) / 2;
        
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    } 
    
    public void merge(Pair[] arr, int low, int mid, int high) {
        // base case
        for (int i = low; i <= high; ++i) {
            temp[i] = arr[i];
        }
        
        int i = low, j = mid + 1;
        for (int p = low; p <= high; ++p) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
            } else if (j == high + 1) {
                arr[p] = temp[i++];
                count[arr[p].index] += j - (mid + 1);
            } else if (temp[i].value <= temp[j].value) {
                arr[p] = temp[i++];
                count[arr[p].index] += j - (mid + 1);
            } else {
                arr[p] = temp[j++];
            }
        }
        
    }
    
}
    
    