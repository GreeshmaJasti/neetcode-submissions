class KthLargest {

    //A min heap of size k that always stores the k largest elements seen so far. 
    //Whenever a new element is added and the heap size exceeds k, the smallest element is removed i.e root, ensuring the heap contains only the top k largest values. 
    //The root of the min heap (peek()) is therefore always the kth largest element. 

    PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();

        int len = nums.length;
        for(int i = 0; i < len; i++){
            pq.add(nums[i]);
            if(i >= k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}
