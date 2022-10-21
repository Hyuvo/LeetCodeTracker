class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String token : tokens) {
            // if an operator, get 2 eles from the top of the stack
            if ("+-*/".contains(token)) {
                // a was pushed later than b
                int a = stack.pop(), b = stack.pop();
                switch(token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                // if an operand, push into stack
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}