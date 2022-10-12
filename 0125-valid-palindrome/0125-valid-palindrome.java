class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String s1 = s.replaceAll("[^A-Za-z0-9]", "");
        String s2 = s1.toLowerCase();
        // 2 pointers
        int p1 = 0, p2 = s2.length() - 1;
        while (p1 < p2) {
            if (s2.charAt(p1) != s2.charAt(p2)) {
                return false;
            } 
            p1++;
            p2--;
        }
        return true;
    }
}