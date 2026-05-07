class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();

        int p1 = 0, p2 = 1, maximumProfit = 0;

        while(p1 < p2 && p2 < n){
            if(prices[p1] < prices[p2]){
                maximumProfit = max(maximumProfit, prices[p2] - prices[p1]);
                p2++;
            }else if(prices[p1] >= prices[p2]){
                p1++;
                p2 = p1+1;
            }
        }
        return maximumProfit;
    }
};
