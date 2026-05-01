class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());

        for(int i = 0; i < n; i++){
            int a = nums[i];
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1, r = n-1;
            while(l < r){
                int sum = a + nums[l] + nums[r];
                if(sum == 0){
                    res.push_back({a, nums[l], nums[r]});
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1])
                        l++;
                    while(l < r && nums[r] == nums[r+1])
                        r--;
                }
                else if(sum < 0)
                    l++;
                else if(sum > 0)
                    r--;
            }
        }
        return res;
    }
};
