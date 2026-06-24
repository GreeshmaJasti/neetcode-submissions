class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> st = new Stack();
        int[] res = new int[len];

        res[len-1] = 0;
        st.push(len-1);
        for(int i = len-2; i >= 0; i--){
            if(st.empty()){
                res[i] = 0;
                st.push(i);
            }
            else{
                while(!st.empty() && temperatures[st.peek()] <= temperatures[i]){
                    st.pop();
                }
                if(!st.empty() && temperatures[st.peek()] > temperatures[i]){
                    res[i] = st.peek() - i;
                }
                st.push(i);
            }
        }
        
        return res;
    }
}
