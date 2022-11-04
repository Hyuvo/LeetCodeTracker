class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;
        // [left, right) as window
        int left = 0, right = 0, valid = 0;
        // track the min substr
        int start = 0, len = INT_MAX;
        while (right < s.size()) {
            // c is the char to be added into the window
            char c = s[right];
            right++;
            // if need this char
            if (need.count(c)) {
                // update window
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            
            // shrink left bound
            while (valid == need.size()) {
                // maintian min substring
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d is the char to be removed from the window
                char d = s[left];
                left++;
                if (need.count(d)) {                    
                    if (need[d] == window[d]) {
                        valid--;                       
                    }
                    // deduct after validate
                    window[d]--;
                }            
            }
        }
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};