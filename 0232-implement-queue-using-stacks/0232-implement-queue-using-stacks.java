class MyQueue {
    Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        // use peek to make sure all eles are moved to s2
        peek();
        return s2.pop();
    }
    
    public int peek() {
        // transfer ele in s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
            s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */