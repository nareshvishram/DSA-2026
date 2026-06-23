class MinStack {
    Stack<Long> st;
    int currMin;

    public MinStack() {
        st = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }

    public void push(int value) {
        if (currMin > value) {
            st.push(2L * value - currMin);
            currMin = value;
        } else
            st.push((long) value);
    }

    public void pop() {
        if (st.isEmpty())
            return;
        if (st.peek() < currMin)
            currMin = (int) (2L * currMin - st.peek());
        st.pop();
    }

    public int top() {
        if (st.peek() < currMin)
            return currMin;
        long peek = st.peek();
        return (int) peek;
    }

    public int getMin() {
        return currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */