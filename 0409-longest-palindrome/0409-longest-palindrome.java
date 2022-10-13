class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        // at least 1-letter long
        int result = 0, pair = 0;
        for (char c : counter.keySet()) {
            pair += (int) counter.get(c) / 2;
            if (counter.get(c) % 2 == 1) result = 1;
        }
        return result + 2 * pair;
    }
}