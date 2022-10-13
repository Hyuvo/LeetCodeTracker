class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // all lowercase letters
        int[] counter = new int[26];
        for (char c : magazine.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            // if magazine does not have enought char for making up ransom
            if (--counter[c - 'a'] < 0) return false;
        }
        return true;
    }
}
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         if (ransomNote.length() > magazine.length()) return false;
//         // lowercase letters
//         HashMap<Character, Integer> counter = new HashMap();
//         for (char c : ransomNote.toCharArray()) {
//             counter.put(c, counter.getOrDefault(c, 0) + 1);
//         }
//         for (char c : magazine.toCharArray()) {
//             counter.put(c, counter.getOrDefault(c, 0) - 1);
//         }
//         for (char c : ransomNote.toCharArray()) {
//             if (counter.get(c) > 0) return false;
//         }
//         return true;
        
//     }
// }