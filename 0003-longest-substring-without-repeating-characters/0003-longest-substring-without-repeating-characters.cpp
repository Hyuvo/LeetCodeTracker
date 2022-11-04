class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;
        // window: [left, right)
        int left = 0, right = 0;
        // substring
        int len = 0;
        while (right < s.size()) {
            // expand window from right
            char c = s[right++];
            window[c]++;
            // shrink window from left if has duplicate chars
            while (window[c] > 1) {
                char d = s[left++];
                window[d]--;
            }
            
            len = max(len, right - left);
        }
        return len;
    }
};