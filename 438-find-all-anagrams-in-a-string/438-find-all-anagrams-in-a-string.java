class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < p.length(); ++i) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int left = 0, right = 0, valid = 0;
        
        while(right < s.length()) {
            char curRight = s.charAt(right);
            ++right;
            if(target.containsKey(curRight)) {
                window.put(curRight, window.getOrDefault(curRight, 0) + 1);
                if(window.get(curRight).equals(target.get(curRight))){
                    ++valid;
                }
            }
            
            while(right - left >= p.length()) {
                if(valid == target.size() && right - left == p.length()) {
                    result.add(left);
                }                
                char curLeft = s.charAt(left);
                ++left;                
                if(target.containsKey(curLeft)) {
                    if(target.get(curLeft).equals(window.get(curLeft))) {
                        --valid;
                    }
                    window.put(curLeft, window.get(curLeft) - 1);
                }
            }
        }
        
        return result;
    }
}