import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] tomatoes;
    private static int[][] days;
    private static Queue<XY> queue;
    private static int max;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        if (!checkAllRiped()) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }

    }

    private static boolean checkAllRiped() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (tomatoes[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[M][N];
        days = new int[M][N];
        queue = new LinkedList<>();
        max = 0;

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                tomatoes[x][y] = Integer.parseInt(st.nextToken());
                if (tomatoes[x][y] == 1) {
                    queue.add(new XY(x, y));
                }
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (
                        canMove(nextX, nextY) && tomatoes[nextX][nextY] == 0
                ) {
                    days[nextX][nextY] = days[now.x][now.y] + 1;
                    max = Math.max(max, days[nextX][nextY]);
                    tomatoes[nextX][nextY] = 1;
                    queue.add(new XY(nextX, nextY));
                }
            }
        }
    }

    private static boolean canMove(int nextX, int nextY) {
        return 0 <= nextX && nextX < M
                && 0 <= nextY && nextY < N
                && tomatoes[nextX][nextY] != -1;
    }

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
