class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> res;

        int p1 = 0, p2 = 1;
        while(p1 < p2 && p2 < n){
            if(temperatures[p1] < temperatures[p2]){
                res.push_back(p2-p1);
                p1++;
                p2 = p1+1;
            }
            else if(p2 == n-1){
                res.push_back(0);
                p1++;
                p2 = p1+1;
            }
            else{
                p2++;
            }
        }
        res.push_back(0);
        return res;
    }
};
