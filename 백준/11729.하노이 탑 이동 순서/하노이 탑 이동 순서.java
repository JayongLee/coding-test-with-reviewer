import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

         sb = new StringBuilder();
         sb.append((1 << N) - 1).append("\n");
         hanoi(1, 3, N);
        System.out.println(sb);
    }

    private static void hanoi(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        // n-1개의 원판을 기둥 a -> 6-a-b로 옮김
        hanoi(a, 6-a-b, n-1);
        // n번 원판을 a -> b
        sb.append(a).append(" ").append(b).append("\n");
        // n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다
        hanoi(6-a-b, b, n-1);
    }
}
