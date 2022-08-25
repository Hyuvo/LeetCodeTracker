class Solution {
    public String longestPalindrome(String s) {
        // for each i, expand the palindrome from the center
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            // s len is odd
            String s1 = palindrome(s, i, i);
            // s len is even
            String s2 = palindrome(s, i, i + 1);
            // keep the longest
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }     
        return result;
    }
    
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // when eligibile for palindrom,
                // expand
                --l;
                ++r;
                // the new border is not check
        }
        // exclusive
        return s.substring(l + 1, r);
    }
}