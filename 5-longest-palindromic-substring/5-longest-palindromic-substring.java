class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0; i < s.length(); ++i) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            //longest(result, s1, s2)
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }
    
    public String palindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                //expand from the center
                l--;
                r++;
        }
        // substr is [l, r) l, r have to be out of bound to stop iteration
        return s.substring(l + 1, r);
    }
}