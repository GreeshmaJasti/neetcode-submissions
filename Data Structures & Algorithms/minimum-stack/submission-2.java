class MinStack {

    private static class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Node> stack;

    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        if(stack.empty())
            stack.push(new Node(val, val));
        else{
            int currentMin = stack.peek().min;
            stack.push(new Node(val, Math.min(currentMin, val)));
        }
    }
    
    public void pop() {
        if(!stack.empty())
            stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
