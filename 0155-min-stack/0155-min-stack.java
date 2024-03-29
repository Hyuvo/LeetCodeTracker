class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
        // so minStack is descending from the bottom of the stack
    }
    // the top of the minStack is the min val
    public void push(int val) {
        stack.push(val);
        // if val is smaller
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        // } else {
        //     // maintain the 2 stacks in the same size
        //     // so they can pop together
        //     minStack.push(minStack.peek());
        // }
    }
    
    public void pop() {
        // Note: use equals()
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        // null check?
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */