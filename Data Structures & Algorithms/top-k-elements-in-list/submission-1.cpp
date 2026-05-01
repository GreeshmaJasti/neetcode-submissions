class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> mp;
        vector<int> res;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            mp[nums[i]]++;
        }
        vector<pair<int, int>> vec(mp.begin(), mp.end());

        sort(vec.begin(), vec.end(), [](const auto& a, const auto& b) {
            return a.second > b.second;
        });

        for (const auto& [key, value] : vec){
            if(res.size() != k)
                res.push_back(key);
            else
                break;
        }
        return res;
    }
};
