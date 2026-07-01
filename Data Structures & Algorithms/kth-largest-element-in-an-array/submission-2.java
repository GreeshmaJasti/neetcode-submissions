class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // Using max heap, priority queue - Collections.reverseOrder()
        // Construct max Heap with Priority Queue - pop k-1 elements and top will be the kth largest
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int len = nums.length;
        // O(n * log n), O(n)
        for(int i = 0; i < len; i++){
            pq.add(nums[i]);
        }
        // O(k * log n), O(1)
        for(int i = 0; i < k-1; i++)
            pq.poll();
        return pq.peek();
    }
}
