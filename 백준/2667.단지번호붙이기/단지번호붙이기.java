import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] apt;
    private static boolean[][] visited;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && apt[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int size : list) {
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Queue<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int i = 0; i < DX.length; i++) {
                int nextX = now.x + DX[i];
                int nextY = now.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (!visited[nextX][nextY] && apt[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new XY(nextX, nextY));
                    count++;
                }
            }
        }
        list.add(count);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(BUFFERED_READER.readLine());
        apt = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = BUFFERED_READER.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                apt[i][j] = line[j] - '0';
            }
        }

        BUFFERED_READER.close();
    }
}
