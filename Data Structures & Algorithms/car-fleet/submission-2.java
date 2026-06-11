class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] pair = new int[len][2];
        Stack<Double> st = new Stack<>();

        for(int i = 0; i < len; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < len; i++){
            double res = (double)(target - pair[i][0])/pair[i][1];
            if(st.empty())
                st.push(res);
            else if(!st.empty() && res > st.peek())
                st.push(res);
        }

        return st.size();
    }
}
