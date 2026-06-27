class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = low + (high-low)/2;
            int res=0;
            for(int i = 0; i < len; i++){
                res += (int)Math.ceil((double)piles[i] / mid);
            }
            if(res > h)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}
