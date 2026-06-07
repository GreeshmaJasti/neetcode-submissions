class MinStack {

    private Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        if(!minStack.empty())
            minStack.pop();
    }
    
    public int top() {
        if(!minStack.empty())
            return minStack.peek();
        return -1;
    }
    
    public int getMin() {
        ArrayList<Integer> list = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        while(!minStack.empty()){
            minValue = Math.min(minValue, minStack.peek());
            list.add(minStack.peek());
            minStack.pop();
        }
        for(int i = list.size()-1; i >= 0; i--){
            minStack.push(list.get(i));
        }
        return minValue;
    }
}
