class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        
        // init window
        int left = 0, right = 0, valid = 0;
        // track the min substr
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            // right exclusive window
            char curRight = s.charAt(right);
            ++right;
            if (target.containsKey(curRight)) {
                window.put(curRight, window.getOrDefault(curRight, 0) + 1);
                if (window.get(curRight).equals(target.get(curRight)))
                    valid++;
            }
            
            // left inclusive window
            // maintian the window
            // valid is the count of chars that meet the # requirement
            while (valid == target.size()) {
                // update if possible min substr
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char curLeft = s.charAt(left);
                ++left;
                if (target.containsKey(curLeft)) {
                    if (window.get(curLeft).equals(target.get(curLeft))) {
                        --valid;
                    }
                    window.put(curLeft, window.get(curLeft) - 1);
                }
            }
        }
        return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
            
    }
}