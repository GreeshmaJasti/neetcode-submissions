class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                st.push(Integer.parseInt(tokens[i]));
            }else{
                int num2 = st.peek();
                st.pop();
                int num1 = st.peek();
                st.pop();
                if(tokens[i].equals("+"))
                    st.push(num1+num2);
                else if(tokens[i].equals("-"))
                    st.push(num1-num2);
                else if(tokens[i].equals("*"))
                    st.push(num1*num2);
                else if(tokens[i].equals("/"))
                    if(num2 != 0)
                        st.push(num1/num2);
            }
        }
        return st.peek();
    }
}
