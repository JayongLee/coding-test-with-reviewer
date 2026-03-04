import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long A, B, C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(long a, long b, long mod) {
        if (b == 1) return a % mod;
        long val = pow(a, b/2, mod);
        val = val * val % mod;
        if (b % 2 == 0) return val;
        return val * a % mod;
    }
}
