class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        // Using monotonic stack - stack that maintains elements in increasing or decreasing order to efficiently find the next greater element
        int n = temperatures.size();
        stack<pair<int, int>> st;
        vector<int> res(n, 0);

        for(int i = 0; i < n; i++){
            int t = temperatures[i];
            while(!st.empty() && t > st.top().first){
                auto pair = st.top();
                st.pop();
                res[pair.second] = i - pair.second;
            }
            st.push({t, i});
        }
        return res;
    }
};
