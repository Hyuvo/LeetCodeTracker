class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < s1.length(); ++i) {
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        int left = 0, right = 0, valid = 0;
        
        while(right < s2.length()) {
            char curRight = s2.charAt(right);
            right++;
            if(target.containsKey(curRight)) {
                window.put(curRight, window.getOrDefault(curRight, 0) + 1);
                if(window.get(curRight).equals(target.get(curRight))) {
                    valid++;
                }
            }
            
            while(right - left >= s1.length()) {
                if(valid == target.size() && right - left == s1.length()) {
                    return true;
                }
                
                char curLeft = s2.charAt(left);
                left++;
                if(target.containsKey(curLeft)) {
                    if(window.get(curLeft).equals(target.get(curLeft))) {
                        valid--;
                    }
                    window.put(curLeft, window.get(curLeft) - 1);
                }
            }
        }
        return false;    
    }
}