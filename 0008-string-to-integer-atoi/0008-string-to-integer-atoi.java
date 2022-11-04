class Solution {
    public int myAtoi(String s) {
        // default sign +
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = s.length();
        
        // 1. ignore leading whitespace
        while (index < n && s.charAt(index) == ' ') index++;
        
        // 2. check the sign
        if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < n && s.charAt(index) == '+') {
            index++;
        }
        
        // 3. read digit
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            // check overflow first
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                // return per sign
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // append to result
            result = result * 10 + digit;
            // don't forget index
            index++;
        }
        return result * sign;
    }
}