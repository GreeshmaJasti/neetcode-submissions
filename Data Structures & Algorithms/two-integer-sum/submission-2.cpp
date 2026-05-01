class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int p1 = 0, p2 = nums.size()-1;
        map<int, vector<int>> idx;
        for(int i = 0; i < nums.size(); i++){
            idx[nums[i]].push_back(i);
        }
        sort(nums.begin(),nums.end());
        vector<int> res;
        while(p1 < p2){
            if(nums[p1]+nums[p2] == target){
                res.push_back(idx[nums[p1]][0]);
                if(nums[p1] == nums[p2])
                    res.push_back(idx[nums[p2]][1]);
                else
                    res.push_back(idx[nums[p2]][0]);
                sort(res.begin(), res.end());
                return res;
            }
            else if(nums[p1]+nums[p2] > target){
                p2--;
            }
            else
                p1++;
        }

        return res;
    }
};
