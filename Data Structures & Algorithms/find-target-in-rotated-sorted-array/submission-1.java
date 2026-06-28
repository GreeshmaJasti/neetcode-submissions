class Solution {
    public int search(int[] nums, int target) {
        // Small extension after finding the smallest element index
        // Once we find the smallest element index, we can just compare and decide we need search in left of smallest element sub array or right side
        // so we are applying binary search for 2 times.
        // (If we don't compare we end of doing for 3 times (searching for smallest, searching for target in left sorted array, searching for target in right sorted array)
        int len = nums.length;
        int low = 0, high = len-1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[high])
                high = mid;
            else
                low = mid +1;
        }
        int smallestIndex = low;

        if(target == nums[smallestIndex])
            return smallestIndex;
        else if(target > nums[smallestIndex] && target <= nums[len-1]){
            int left = smallestIndex, right = len-1;

            while(left <= right){
                int middle = left + (right - left)/2;

                if(nums[middle] == target)
                    return middle;
                else if(target > nums[middle])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            return -1;
        }else{
            int left = 0, right = smallestIndex;

            while(left <= right){
                int middle = left + (right - left)/2;

                if(nums[middle] == target)
                    return middle;
                else if(target > nums[middle])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            return -1;
        }
    }
}
