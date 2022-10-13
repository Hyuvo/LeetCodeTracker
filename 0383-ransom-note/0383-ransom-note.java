class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        // lowercase letters
        HashMap<Character, Integer> counter = new HashMap();
        for (char c : ransomNote.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (counter.get(c) > 0) return false;
        }
        return true;
        
    }
}