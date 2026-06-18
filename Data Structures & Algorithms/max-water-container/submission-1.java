class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int p1 = 0, p2 = n-1;
        int max_Area = 0;
        while(p1 <= p2){
            int min = Math.min(heights[p1], heights[p2]);
            max_Area = Math.max(max_Area, min*(p2-p1));
            if(heights[p1] <= heights[p2])
                p1++;
            else
                p2--;
        }
        return max_Area;
    }
}
