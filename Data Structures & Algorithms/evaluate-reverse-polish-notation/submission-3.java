class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(String token: tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                st.push(Integer.parseInt(token));
            }else{
                int num2 = st.pop();
                int num1 = st.pop();

                switch(token){
                    case "+":
                        st.push(num1 + num2);
                        break;
                    case "-":
                        st.push(num1 - num2);
                        break;
                    case "*":
                        st.push(num1 * num2);
                        break;
                    case "/":
                        if(num2 != 0)
                            st.push(num1 / num2);
                        break;
                }
            }
        }
        return st.pop();
    }
}
