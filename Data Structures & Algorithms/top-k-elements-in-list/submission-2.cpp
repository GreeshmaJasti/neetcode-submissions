class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> topK;
        map<int, int> mp;

        int n = nums.size();

        for(int i = 0; i < n; i++){
            mp[nums[i]]++;
        }

        vector<pair<int, int>> pairs;
        for(auto m : mp){
            pairs.push_back({m.second, m.first});
        }

        sort(pairs.rbegin(), pairs.rend());

        for(auto pair:pairs){
            if(topK.size() != k)
                topK.push_back(pair.second);
            else
                break;
        }

        return topK;
    }
};
