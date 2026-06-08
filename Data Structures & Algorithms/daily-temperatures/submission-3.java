class Node {
    int val;
    int idx;

    Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Node> st = new Stack<>();

        res[n-1] = 0;
        st.push(new Node(temperatures[n-1], n-1));
        for(int i = n-2; i >=0; i--){
            if(st.empty()){
                res[i] = 0;
            }
            while(!st.empty()){
                int num = st.peek().val;
                if(temperatures[i] < num){
                    res[i] = st.peek().idx - i;
                    break;
                }else{
                    st.pop();
                }
            }
            st.push(new Node(temperatures[i], i));
        }
        
        return res;
    }
}
