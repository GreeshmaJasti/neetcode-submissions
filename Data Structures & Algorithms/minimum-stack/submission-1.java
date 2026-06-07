class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> minValue;

    public MinStack() {
        minStack = new Stack();
        minValue = new Stack();
    }
    
    public void push(int val) {
        minStack.push(val);
        if(minValue.empty())
            minValue.push(val);
        else 
            minValue.push(Math.min(val, minValue.peek()));
    }
    
    public void pop() {
        if(!minStack.empty() && !minValue.empty()){
            minStack.pop();
            minValue.pop();
        }
    }
    
    public int top() {
        if(!minStack.empty())
            return minStack.peek();
        return -1;
    }
    
    public int getMin() {
        if(!minValue.empty())
            return minValue.peek();
        return -1;
    }
}
