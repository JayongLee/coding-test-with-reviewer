import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[] map;
    private static int[] count;
    private static boolean[] visited;
    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs(N));
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[MAX + 1];
        count = new int[MAX + 1];
        visited = new boolean[MAX + 1];
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i <= 2; i++) {
                int next = next(i, now);
                if (0 <= next && next <= MAX && !visited[next]) {
                    count[next] = count[now] + 1;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return count[K];
    }

    private static int next(int index, int num) {
        switch (index) {
            case 0 : return num - 1;
            case 1 : return num + 1;
            case 2 : return num * 2;
        }
        return 0;
    }
}
