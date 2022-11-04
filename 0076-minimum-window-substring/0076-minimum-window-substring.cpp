class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;
        // window: [left, right)
        int left = 0, right = 0, valid = 0;
        // substring
        int start = 0, len = INT_MAX;
        
        while (right < s.size()) {
            // c is to be added into the window
            char c = s[right++];
            // maintain window
            if (need.count(c)) {
                window[c]++;
                if (need[c] == window[c]) {
                    valid++;
                }
            }
            // shrink left bound
            while (valid == need.size()) {
                // update min substr
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d is to be removed from the left
                char d = s[left++];                
                if (need.count(d)) {
                    if (need[d] == window[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }           
        }
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};