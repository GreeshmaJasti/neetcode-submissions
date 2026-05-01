class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int n = nums.size();
        if(n == 0)
            return 0;
        int longest = 0, res = 0;

        for(int i = 1; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]+1)
                res++;
            else if(i > 0 && nums[i] == nums[i-1])
                continue;
            else{
                longest = max(longest, res);
                res = 0;
            }
        }

        return max(res, longest)+1;
    }
};
