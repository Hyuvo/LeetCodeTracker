class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> left = new Stack();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            // push left parenthesis in stack
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else if (map.containsKey(c)) {
                // once seen right paren, check the top of the stack
                if (!left.isEmpty() && map.get(c) == left.peek()) {
                    // pop if get a match
                    left.pop();
                } else return false; // not a match, invalid
            }
        }
        
        // see if every left paranthesis gets a match
        return left.isEmpty();
    }
}