import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static boolean[][] visited;
    private static int[][] dist;
    private static int[][] map;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<XY> queue = new LinkedList<>();
        visited[x][y] = true;
        dist[x][y] = 1;
        queue.add(new XY(x, y));
        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dx[i], now.y + dy[i]);
                if (inMap(next) && !visited[next.x][next.y] && map[next.x][next.y] == 1 && dist[next.x][next.y] == 0) {
                    dist[next.x][next.y] = dist[now.x][now.y] + 1;
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
        return dist[n-1][m-1];
    }

    private static boolean inMap(XY xy) {
        return 0 <= xy.x && xy.x < n && 0 <= xy.y && xy.y < m;
    }

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j] + "");
            }
        }
    }
}
