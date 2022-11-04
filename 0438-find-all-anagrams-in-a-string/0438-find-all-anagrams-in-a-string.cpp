class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        unordered_map <char, int> window, need;
        for (char c : p) need[c]++;
        
        // window: [left, right)
        int left = 0, right = 0, valid = 0;

        
        while (right < s.size()) {
            char c = s[right++];
            
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            // when window > p.len, shrink window from left
            while (right - left >= p.size()) {
                // update result
                if (valid == need.size()) {
                    result.push_back(left);
                }
                
                char d = s[left++];
                if (need.count(d)) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }           
        }
        return result;
    }
};