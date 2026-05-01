class Solution {
public:
    int maxArea(vector<int>& heights) {
        int n = heights.size();
        int p1 = 0, p2 = n-1, max_water = 0;
        while(p1 < p2){
            int water = (p2 - p1) * min(heights[p1], heights[p2]);
            max_water = max(max_water, water);
            if(heights[p1] > heights[p2])
                p2--;
            else if(heights[p1] <= heights[p2])
                p1++;
        }
        return max_water;
    }
};
