class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Making sure my priority queue has k elements.
        // if we reach k, we remove top and reheapify.
        // After constructing with all elements, return top, because each time min is deleted, k largest elements stay in heap.

        // TC: O(n * log k), SC: O(k)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int len = nums.length;
        for(int i = 0; i < len; i++){
            pq.add(nums[i]);
            if(i >= k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
