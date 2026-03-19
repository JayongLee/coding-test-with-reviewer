import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, S;
    private static int[] arr;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        if (S == 0) ans--; // empty set
        System.out.println(ans);
    }

    private static void backtrack(int idx, int total) {
        if (idx == N) {
            if (total == S) ans++;
            return;
        }
        backtrack(idx + 1, total);
        backtrack(idx + 1, total + arr[idx]);
    }
}
