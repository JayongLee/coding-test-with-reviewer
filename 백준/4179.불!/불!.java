//package baaarkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static char[][] map;
    private static int[][] dist;
    private static XY userStart;
    private static Queue<XY> fireQueue;
    private static int[][] fireTime;

    public static void main(String[] args) throws IOException {
        init();
        fire();
        int ans = bfs();
        if (ans == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }

    private static int bfs() {
        Queue<XY> userQueue = new LinkedList<>();
        userQueue.add(new XY(userStart.x, userStart.y));
        dist[userStart.x][userStart.y] = 0;

        while (!userQueue.isEmpty()) {
            XY now = userQueue.poll();
            // 4방향
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                // 탈출
                if (isEscape(nextX, nextY)) {
                    return dist[now.x][now.y] + 1;
                }
                if (
                        map[nextX][nextY] != '#' && dist[nextX][nextY] == -1 // 벽이 아니고 아직 안가본 곳
                        && (dist[now.x][now.y] + 1 < fireTime[nextX][nextY] || fireTime[nextX][nextY] == -1) // 불이 안나거나 늦게 나는 경우
                ) {
                    userQueue.add(new XY(nextX, nextY));
                    dist[nextX][nextY] = dist[now.x][now.y] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isEscape(int nextX, int nextY) {
        return !(canMove(nextX, nextY));
    }

    private static void fire() {
        while (!fireQueue.isEmpty()) {
            XY now = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (canMove(nextX, nextY) && map[nextX][nextY] != '#' && fireTime[nextX][nextY] == -1) {
                    fireTime[nextX][nextY] = fireTime[now.x][now.y] + 1;
                    fireQueue.add(new XY(nextX, nextY));
                }
            }
        }
    }

    private static boolean canMove(int nextX, int nextY) {
        return 0 <= nextX && nextX < N && 0 <= nextY && nextY < M;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M];
        fireTime = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(fireTime[i], -1); // 불이 안난 곳 -1로 초기화
            Arrays.fill(dist[i], -1);
        }
        fireQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'J') {
                    userStart = new XY(i, j);
                } else if (map[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    fireQueue.add(new XY(i, j));
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
