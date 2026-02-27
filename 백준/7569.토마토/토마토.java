import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, H;
    private static int[][][] tomatoes;
    private static int[][][] days;
    private static Queue<XYZ> queue;
    private static int max;

    private static final int[] dx = {1, 0, -1, 0, 0, 0};
    private static final int[] dy = {0, 1, 0, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

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
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (tomatoes[x][y][z] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoes = new int[M][N][H];
        days = new int[M][N][H];
        queue = new LinkedList<>();
        max = 0;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    tomatoes[x][y][z] = Integer.parseInt(st.nextToken());
                    if (tomatoes[x][y][z] == 1) {
                        queue.add(new XYZ(x, y, z));
                    }
                }
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            XYZ now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = now.x + dx[i]; int nextY = now.y + dy[i]; int nextZ = now.z + dz[i];
                if (
                        canMove(nextX, nextY, nextZ) && tomatoes[nextX][nextY][nextZ] == 0
                ) {
                    days[nextX][nextY][nextZ] = days[now.x][now.y][now.z] + 1;
                    max = Math.max(max, days[nextX][nextY][nextZ]);
                    tomatoes[nextX][nextY][nextZ] = 1;
                    queue.add(new XYZ(nextX, nextY, nextZ));
                }
            }
        }
    }

    private static boolean canMove(int nextX, int nextY, int nextZ) {
        return 0 <= nextX && nextX < M
                && 0 <= nextY && nextY < N
                && 0 <= nextZ && nextZ < H
                && tomatoes[nextX][nextY][nextZ] != -1;
    }

    static class XYZ {
        int x;
        int y;
        int z;

        public XYZ(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
