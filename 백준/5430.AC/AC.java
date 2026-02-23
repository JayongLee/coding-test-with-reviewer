import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static Deque<Integer> deque;
    private static boolean isReverse;
    private static StringBuilder ans;

    public static void main(String[] args) throws IOException {
        // R 배열 뒤집기
        // D 첫번째 수 버리기
        T = Integer.parseInt(br.readLine());
        ans = new StringBuilder();

        for (int i = 0; i < T; i++) {
            char[] commands = initCommand(br.readLine());
            int n = Integer.parseInt(br.readLine());
            isReverse = false;
            initDeque(br.readLine());
            String executed = execute(commands);
            ans.append(executed).append("\n");
        }

        System.out.println(ans);
    }

    private static String execute(char[] commands) {
        boolean isError = false;
        for (char c : commands) {
            if (isError) break;
            switch (c) {
                case 'R' : // 뒤집기
                    isReverse = !isReverse;
                    break;

                case 'D' :
                    int result = D();
                    if (result == 0) {
                        isError = true;
                    }
                    break;
            }
        }
        if (isError) return "error";
        return buildResult();
    }

    private static String buildResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!deque.isEmpty()) {
            if (isReverse) {
                sb.append(deque.removeLast());
            } else {
                sb.append(deque.removeFirst());
            }
            if (!deque.isEmpty()) sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }

    private static int D(){
        if (deque.isEmpty()) return 0;
        if (isReverse) {
            return deque.removeLast();
        } else return deque.removeFirst();
    }

    private static char[] initCommand(String commands) {
        return commands.toCharArray();
    }

    private static void initDeque(String arr) {
        deque = new ArrayDeque<>();
        arr = arr.replace("[", "").replace("]", "");
        if (arr.isEmpty()) return;
        for (String s : arr.split(",")) {
            deque.add(Integer.parseInt(s));
        }
    }
}
