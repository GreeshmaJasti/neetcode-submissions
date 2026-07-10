class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // We have to find the correct partition, to find the partitions, we are applying binary search.
        // Identify one valid partition.
        // Once correct partition is found, if elements are even - (max(l1, l2) + min(r1, r2))/2; if odd - max(l1,l2);
        int m = nums1.length;
        int n = nums2.length;

        if(m > n)
            findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = m;

        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = (m+n)/2 - mid1;

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            double r1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            double r2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if((m+n)%2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return Math.min(r1,r2);
            }
            else if(l1 > r2)
                high = mid1-1;
            else
                low = mid1+1;
        }
        return 0.0;
    }
}
