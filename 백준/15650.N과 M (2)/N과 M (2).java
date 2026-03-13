import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M;
    private static int[] seq;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        seq = new int[M];
        visited = new boolean[N+1];

        backtrack(0);
        System.out.println(sb);
    }

    private static void backtrack(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (count > 0 && i < seq[count - 1]) continue;
                visited[i] = true;
                seq[count] = i;
                backtrack(count + 1);
                visited[i] = false;
            }
        }
    }
}
