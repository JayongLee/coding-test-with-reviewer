import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayDeque<Integer> queue;
    private static StringBuilder ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();
        ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.countTokens();
            String command = st.nextToken();
            int num = st.hasMoreTokens()
                    ? Integer.parseInt(st.nextToken())
                    : 0;
            command(command, num);
        }

        System.out.println(ans);
    }

    private static void command(String command, int num) {
        switch (command) {
            case "push" :
                queue.add(num);
                break;

            case "pop" :
                if (queue.isEmpty()) ans.append(-1).append("\n");
                else ans.append(queue.poll()).append("\n");
                break;

            case "size" :
                ans.append(queue.size()).append("\n");
                break;

            case "empty" :
                if (queue.isEmpty()) ans.append(1).append("\n");
                else ans.append(0).append("\n");
                break;

            case "front" :
                if (queue.isEmpty()) ans.append(-1).append("\n");
                else ans.append(queue.peek()).append("\n");
                break;

            case "back" :
                if (queue.isEmpty()) ans.append(-1).append("\n");
                else ans.append(queue.getLast()).append("\n");
                break;
        }
    }
}
