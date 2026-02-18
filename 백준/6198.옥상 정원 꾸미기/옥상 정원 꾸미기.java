import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long ans = 0L;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine()); // 다음 높이
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                } else break;
            }
            ans += stack.size();
            stack.push(height);
        }

        System.out.println(ans);
    }
}
