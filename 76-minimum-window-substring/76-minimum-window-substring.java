class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            // need[i]++
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // the window is [left, right)
        int left = 0, right = 0, valid = 0; // valid is the # of qualified char in window
        // start is the start index of the current min substring
        // len is the current len of the current min substring
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()) {
            // the char that is going to be added to the window
            char curRight = s.charAt(right);
            // expand the window
            ++right;      
            //update window data
            if(need.containsKey(curRight)) {
                //window[curRight]++
                //window is to track #of needed char in current window
                window.put(curRight, window.getOrDefault(curRight, 0) + 1);
                if(window.get(curRight).equals(need.get(curRight))){
                    ++valid;
                }
            }
            
            //if the window is qualified to shrink
            while(valid == need.size()) {
                // update the min substring
                if(right - left < len) {
                    // maintain the info of min substring
                    start = left;
                    len = right - left;
                }
                // the char that is gonna be removed from the window
                char curLeft = s.charAt(left);
                //shrink the window
                ++left;
                
                // maintain the info of the window
                if(need.containsKey(curLeft)) {
                    // if window[curLeft] == need[curLeft]
                    if(window.get(curLeft).equals(need.get(curLeft))) {
                        --valid;                      
                    }
                    //window[d]-- 
                    window.put(curLeft, window.get(curLeft) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}