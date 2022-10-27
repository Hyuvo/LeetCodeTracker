class Solution {
    public int calculate(String s) {
        // s = "(2 - 5)";
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
        // init first sign and temp result
        char sign = '+';
        int num = 0;
        // process the string till the end
        while (deque.size() > 0) {
            char c = deque.poll();
            if (Character.isDigit(c)) {
                // add up
                num = num * 10 + (c - '0');                
            }
            if (c == '(') {
                // recursively calculate the lefted part as a whole
                num = calculate(deque);
            }
            // encouter a sign or reach the end of the expression
            if (!Character.isDigit(c) || deque.size() == 0) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // reset sign and temp result for next digit
                sign = c;
                num = 0;
            }
            if (c == ')') break;
                      
        }
        int sum = 0;
        for (int digit : stack) {
            sum += digit;
        }
        return sum;
    }
}