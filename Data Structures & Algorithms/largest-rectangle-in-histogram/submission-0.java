class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int len = heights.length;
        int maxi = 0,pse=0;

        for(int i = 0; i < len; i++){
            if(!st.empty()){
                while(!st.empty() && heights[st.peek()] >= heights[i]){
                    int top = st.pop();
                    if(st.empty())
                        pse = -1;
                    else
                        pse = st.peek();
                    maxi = Integer.max(maxi, heights[top]*(i- pse -1));
                }
                st.push(i);
            }else{
                st.push(i);
            }
        }

        while(!st.empty()){
            int top = st.pop();
            if(st.empty())
                pse = -1;
            else
                pse = st.peek();
            maxi = Integer.max(maxi, heights[top]*(len - pse -1));
        }

        return maxi;
    }
}
