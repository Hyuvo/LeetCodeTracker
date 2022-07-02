class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();         
        for(int i = 0; i < s.length(); ++i) {
            Character sChar = s.charAt(i), tChar = t.charAt(i);
            if(!map.containsValue(tChar)) {
                map.putIfAbsent(sChar, tChar);
            }
            // map.putIfAbsent(tChar, sChar);
            // if b == b already, b cannot be mapped to d
            // if(!sChar.equals(tChar)) {
            //     map.putIfAbsent(sChar, tChar);
            if(!map.containsKey(sChar) || !map.get(sChar).equals(tChar)) return false;
        }
        return true;        
    }
}