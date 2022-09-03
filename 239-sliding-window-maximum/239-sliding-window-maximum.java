class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init the window as a monotonely decreasing queue
        MonotonicQueue decreaseQ = new MonotonicQueue();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            // fulfill the window first
            if (i < k - 1) {
                decreaseQ.push(nums[i]);
            } else {
                decreaseQ.push(nums[i]);
                // i >= k, the window is full, track the current max val
                result.add(decreaseQ.max());
                // pop the left most outta window
                decreaseQ.pop(nums[i - k + 1]);
            }
        }
        
        // turn List to array
        int[] maxVals = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            maxVals[i] = result.get(i);
        }
        return maxVals;
    }
}

class MonotonicQueue {
    // a descending queue
    private LinkedList<Integer> decreaseQ = new LinkedList<>();
    
    // add new num to the tail of the q
    public void push(int n) {
        // maintain decreasing, delete every num that is smaller than the new num n
        while (!decreaseQ.isEmpty() && decreaseQ.getLast() < n) {
            decreaseQ.pollLast();
        }
        decreaseQ.addLast(n);
    }
    
    // get the max val of the q, which should be the head
    public int max() {
        return decreaseQ.getFirst();
    }
    
    // delete the num that just move outta the window(in case it is the head, still not deleted)
    // if it is not the max, it won't affect the result
    public void pop(int n) {
        if (decreaseQ.getFirst() == n) {
            decreaseQ.pollFirst();
        }
    }
}