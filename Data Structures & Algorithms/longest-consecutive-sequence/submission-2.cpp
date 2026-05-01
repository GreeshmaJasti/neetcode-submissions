class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> st(nums.begin(), nums.end());
        int n = nums.size(), longest = 0, length = 0;

        for(int num : st){
            if(st.find(num-1) == st.end()){
                length = 1;
                while(st.find(num+length) != st.end())
                    length++;
                longest = max(longest, length);
            }
        }
        return longest;
    }
};
