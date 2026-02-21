import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int next = arr[i];
            while (!stack.isEmpty()) {
                if (stack.peek() > next) {
                    ans[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            }
            stack.push(next);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = N-1; i >= 0; i--) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
