import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean isGoodWord(String word) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'A') {
                if (stack.peek() == 'A') stack.pop();
                else stack.push(c);
            }
            if (c == 'B') {
                if (stack.peek() == 'B') stack.pop();
                else stack.push(c);
            }
        }

        while (stack.size() > 1) {
            if (!stack.removeLast().equals(stack.removeFirst())) return false;
        }
        return stack.size() != 1;
    }
}
