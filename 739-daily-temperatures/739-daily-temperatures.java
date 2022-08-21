class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // cares about the index instead of val
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                
                s.pop();
            }
            answer[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return answer;
    }
}