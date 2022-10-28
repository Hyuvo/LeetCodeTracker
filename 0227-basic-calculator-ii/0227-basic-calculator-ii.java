class Solution {
    public int calculate(String s) {
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != ' ') {
                deque.offer(c);
            }
        }
        
        return calculate(deque);
    }
    
    private int calculate(Deque<Character> deque) {
        Deque<Integer> stack = new ArrayDeque();
        
        // init sign and num for the 1st num
        char sign = '+';
        int num = 0;
        
        while (deque.size() > 0) {
            char curr = deque.poll();
            // sum up digits
            if (Character.isDigit(curr)) {
                num = 10 * num + (curr - '0');
            }
            if (curr == '(') {
                // regard () as an entire num
                num = calculate(deque);
            }
            // if encounter the operator or reach the end
            // operate the num and update sign to the operator
            if (!Character.isDigit(curr) || deque.size() == 0) {
                switch(sign) {
                    case '+':
                        stack.push(num); break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        stack.push(stack.pop() * num); break;
                    case '/':
                        stack.push(stack.pop() / num); break;
                }
                // update the sign and reset num
                sign = curr;
                num = 0;
            }
            if (curr == ')') break;
        }
        int result = 0;
        // sum up all digits in the stack
        for (int digit : stack) {
            result += digit;
        }
        return result;
    }   
}