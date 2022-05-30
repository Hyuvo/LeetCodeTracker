class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Use a hash to track the index of each Char
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0;
        // Use 2 pointers to track the longest substrings
        // Use i to scan the string, and update the index of a seen Char
        for(int i = 0, j = 0; i < s.length(); ++i){
            // Once a Char has been seen, move j to the right of the indice last seen
            if (charMap.containsKey(s.charAt(i))){
                j = Math.max(j, charMap.get(s.charAt(i)) + 1);
            } 
            // update maxLen
            maxLen = Math.max(maxLen, i - j + 1);
            // update the index of the ith Char
            charMap.put(s.charAt(i), i);        
        }
        return maxLen;
    }
}