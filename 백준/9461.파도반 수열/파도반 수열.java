import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static long[] seq;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        seq = new long[101];
        seq[0] = 0; seq[1] = 1; seq[2] = 1; seq[3] = 1; seq[4] = 2; seq[5] =2;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ans.append(findSeq(N)).append("\n");
        }
        System.out.println(ans);
    }

    private static long findSeq(int N) {
        if (seq[N] != 0) return seq[N];
        seq[N] = findSeq(N-1) + findSeq(N-5);
        return seq[N];
    }
}
