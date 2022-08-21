class MedianFinder {    
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        // put the less-value half of the nums in low, which should be a max heap
        low = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        // put the greater-value half of the nums in high, which should be a min heap
        high = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        // while adding new num, balance the size of the 2 heaps
        // but when add it to the smaller size heap, add it to another one, to automatically seperate the greater val and less val
        if (low.size() > high.size() || low.size() == high.size()) {
            //should put num in high
            // high.size == low.size or high.size - low.size = 1
            low.offer(num);
            int temp = low.poll();
            high.offer(temp);
        } else {
            high.offer(num);
            int temp = high.poll();
            low.offer(temp);
        }
    }
    
    public double findMedian() {
        if (low.size() == high.size()) {
            return (double) (low.peek() + high.peek()) / 2;
        } else {
            // as high.size >= low.size()
            return high.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */