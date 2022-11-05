class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            
            result = s1.length() > result.length() ? s1 : result;
            result = s2.length() > result.length() ? s2 : result;
        }
        return result;
    }
    
    // 2 pointers, expand from center
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return s.substring(l + 1, r);
    }
}