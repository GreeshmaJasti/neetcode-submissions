class Solution {
    // Constructing a max heap, and each time we can remove 2 max elements, and adding the difference to the heap
    // We should perform this until the heap size is >= 2
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = stones.length;

        for(int i = 0; i < len; i++){
            pq.add(stones[i]);
        }

        while(pq.size() >= 2){
            int l1 = pq.poll();
            int l2 = pq.poll();
            if(l1 != l2)
                pq.add(l1-l2);
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}
