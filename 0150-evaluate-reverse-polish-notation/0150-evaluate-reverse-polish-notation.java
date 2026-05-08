class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (String s : tokens) {
            if (s.equals("*") || s.equals("-") || s.equals("+") || s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(operation(a, b, s));
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }

    private int operation(int a, int b, String s) {
        switch (s) {
            case "*":
                return a * b;
            case "-":
                return b - a;
            case "+":
                return a + b;
            default:
                return b / a;
        }
    }
}