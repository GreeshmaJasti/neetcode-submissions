class Solution {
    public int findMin(int[] nums) {
        // because the array is sorted and rotated, we are comparing mid with right pointer and moving mid for the minimum element side
        int len = nums.length;

        int low = 0, high = len-1;

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[high])
                high = mid;
            else if(nums[low] <= nums[mid])
                low = mid+1;
        }
        return nums[low];
    }
}
