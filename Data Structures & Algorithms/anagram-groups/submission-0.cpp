class Solution {
public:

    bool checkAnagrams(string s1, string s2){
        map<char, int> mp;
        int m = s1.length(), n = s2.length();
        if(m != n)
            return false;
        else{
            for(int i = 0; i < m; i++){
                mp[s1[i]]++;
            }
            for(int j = 0; j < n; j++){
                mp[s2[j]]--;
            }

            for(auto it:mp){
                if(it.second != 0)
                    return false;
            }
            return true;
        }
    }
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
        vector<vector<string>> res;
        vector<string> temp;
        for(int i = 0; i < n; i++){
            string s = strs[i];
            int tmp = 0;
            for(int j = 0; j < res.size(); j++){
                if(checkAnagrams(res[j][0], s) == true){
                    res[j].push_back(s);
                    tmp = 1;
                }
            }
            if(tmp == 0){
                temp.push_back(s);
                res.push_back(temp);
                temp.clear();
            }
        }
        return res;
    }
};
