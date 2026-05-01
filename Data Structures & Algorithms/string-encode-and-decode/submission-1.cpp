#include <string>
#include <vector>

class Solution {
public:

    string encode(vector<string>& strs) {
        string res;
        int n = strs.size();
        for(int i = 0; i < n; i++){
            res += to_string(strs[i].length()) + '#' + strs[i];
        }
        return res;
    }

    vector<string> decode(string s) {
        vector<string> res;
        int n = s.length();
        int i = 0;
        while(i < n){
            int j = i;
            while(s[j] != '#')
                j++;
            // j-i is to find the relative distance
            int len = stoi(s.substr(i, j-i));
            string temp = s.substr(j+1, len);
            res.push_back(temp);
            i = j + 1 + len;
        }
        return res;
    }
};
