import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr, seq;
    private static boolean[] visited;
    private static StringTokenizer st;
    private static String line;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        line = br.readLine();
        sb = new StringBuilder();
        seq = new int[6];
        while (!line.equals("0")) {
            init();
            backtrack(0);
            sb.append("\n");
            line = br.readLine();
        }

        System.out.println(sb);
    }

    private static void backtrack(int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int idx = 0; idx < arr.length; idx++) {
            if (!visited[idx]) {
                if (count > 0 && arr[idx] < seq[count - 1]) continue;
                visited[idx] = true;
                seq[count] = arr[idx];
                backtrack(count + 1);
                visited[idx] = false;
            }
        }
    }

    private static void init() {
        st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        arr = new int[N]; visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
