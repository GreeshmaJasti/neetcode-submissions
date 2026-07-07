class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < len; i++)
            mp.put(tasks[i], mp.getOrDefault(tasks[i], 0) + 1);
        
        pq.addAll(mp.entrySet());

        Map<Character, Integer> temp = new HashMap<>();
        int res = 0;
        while(!pq.isEmpty()){
            int minCycles = 0;
            while(!pq.isEmpty() && !((n+1) == minCycles)){
                Map.Entry<Character,Integer> t = pq.poll();
                if(t.getValue() > 1)
                    temp.put(t.getKey(), t.getValue()-1);
                minCycles++;
            }

            if(temp.size() == 0)
                res += minCycles;
            else if(n+1 == minCycles)
                res += minCycles;
            else 
                res += n+1;
            pq.addAll(temp.entrySet());
            temp.clear();
        }
        return res;
    }
}
