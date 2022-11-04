class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> window, need;
        for (char c : p) need[c]++;
        int left = 0, right = 0, valid = 0;
        vector<int> result;
        while (right < s.size()) {
            char c = s[right++];
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            
            
            while (right - left >= p.size()) {
                if (valid == need.size()) {
                    result.push_back(left);
                }
                char d = s[left++];
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }
         }
        return result;
    }
};