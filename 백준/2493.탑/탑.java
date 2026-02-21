import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Top {
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Top[] tops = new Top[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tops[i] = new Top(i, Integer.parseInt(st.nextToken()));
        }
        ArrayDeque<Top> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        // Mono Stack
        for (int i = 0; i < N; i++) {
            Top top = tops[i];
            while (!stack.isEmpty()) {
                if (stack.peek().height > top.height) {
                    sb.append(stack.peek().index + 1).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(top);
        }

        System.out.println(sb);
    }
}
