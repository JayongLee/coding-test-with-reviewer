import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (next == 0) {
                int pop = 0;
                if (!pq.isEmpty()) pop = pq.poll();
                sb.append(pop).append("\n");
            } else if (next > 0) {
                pq.add(next);
            }
        }
        System.out.println(sb);
    }
}
