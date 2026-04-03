class MinStack {
    Stack<Integer> currentValues;
    Stack<int[]> minValues;

    public MinStack() {
        currentValues = new Stack<>();
        minValues = new Stack<>();
    }
    
    public void push(int val) {
        currentValues.push(val);
        if(minValues.isEmpty() || val < minValues.peek()[0]) {
            minValues.add(new int[] {val, 1});
        } else if(minValues.peek()[0] == val) {
            minValues.peek()[1]++;
        }
    }
    
    public void pop() {
        if(!currentValues.isEmpty()) {
            if(minValues.peek()[0] == currentValues.peek()) {
                minValues.peek()[1]--;
            }

            if(minValues.peek()[1] == 0) {
                minValues.pop();
            }
            currentValues.pop();            
        }
    }
    
    public int top() {
        return currentValues.isEmpty() ? -1 : currentValues.peek();
    }
    
    public int getMin() {
        return minValues.isEmpty() ? 0 : minValues.peek()[0];
    }
}
