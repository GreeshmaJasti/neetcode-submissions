class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char, int> mp;
        int m = s.size(), n = t.size();
        if(m != n)
            return false;
        for(int i = 0; i < m; i++){
           mp[s[i]]++;
        }

        for(int i = 0; i < n; i++){
            mp[t[i]]--;
        }

        for(int i = 0; i < m; i ++){
            if(mp[t[i]] != 0)
                return false;
        }
        return true;
    }
};
