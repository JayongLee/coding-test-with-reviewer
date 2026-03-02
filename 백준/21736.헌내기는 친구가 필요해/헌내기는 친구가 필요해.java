import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static char[][] map;
    private static boolean[][] visited;
    private static XY start;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        int count = bfs();
        if (count == 0) {
            System.out.println("TT");
        } else System.out.println(count);
    }

    private static int bfs() {
        Queue<XY> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (canMove(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                    if (map[nextX][nextY] == 'P') count++;
                    queue.add(new XY(nextX, nextY));
                    visited[nextX][nextY] =true;
                }
            }
        }
        return count;
    }

    private static boolean canMove(int nextX, int nextY) {
        return 0 <= nextX && nextX < N
                && 0 <= nextY && nextY < M;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'I') {
                    start = new XY(i, j);
                }
            }
        }
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
