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
    private static int[][] map;
    private static int count, max;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!visited[x][y] && map[x][y] == 1) {
                    int area = bfs(x, y);
                    max = Math.max(area, max);
                    count++;
                }
            }
        }

        System.out.println(count + "\n" + max);
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0; count = 0;
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
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

    private static boolean inMap(XY xy) {
        return xy.x >= 0 && xy.x < n && xy.y >= 0 && xy.y < m;
    }

    private static int bfs(int x, int y) {
        Queue<XY> que = new LinkedList<>();
        visited[x][y] = true;
        int area = 1;
        que.add(new XY(x, y));
        while (!que.isEmpty()) {
            XY now = que.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dx[i], now.y + dy[i]);
                if (inMap(next) && !visited[next.x][next.y] && map[next.x][next.y] == 1) {
                    que.add(next);
                    visited[next.x][next.y] = true;
                    area++;
                }
            }
        }
        return area;
    }
}
