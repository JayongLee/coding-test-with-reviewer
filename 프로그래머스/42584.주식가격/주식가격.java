import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int N = prices.length;
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int next = prices[i];
            while (!stack.isEmpty()) {
                if (prices[stack.peek()] > next) { // 가격이 떨어짐
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = N - (idx + 1);
        }
        return answer;
    }
}
