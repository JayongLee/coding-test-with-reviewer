// package baaarkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] draw;
    private static boolean[][] visited;
    private static boolean[][] blindVisited;
    private static Queue<XY> queue;
    private static boolean isBlind;

    private static final int DIRECTION_MAX_INDEX = 4;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int area;
    private static int blindArea;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
                if (!blindVisited[i][j]) {
                    blindBfs(i, j);
                }
            }
        }

        System.out.println(area + " " + blindArea);
    }

    private static void blindBfs(int i, int j) {
        queue.add(new XY(i, j));
        boolean isBlue = draw[i][j] == 'B';
        blindVisited[i][j] = true;

        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int idx = 0; idx < DIRECTION_MAX_INDEX; idx++) {
                int nextX = now.x + dx[idx];
                int nextY = now.y + dy[idx];

                if (!canMove(nextX, nextY)) continue; // 밖
                if (!blindVisited[nextX][nextY]) {
                    if (isBlue && draw[nextX][nextY] == 'B') {
                        blindVisited[nextX][nextY] = true;
                        queue.add(new XY(nextX, nextY));
                    } else if (!isBlue && draw[nextX][nextY] != 'B') {
                        blindVisited[nextX][nextY] = true;
                        queue.add(new XY(nextX, nextY));
                    }
                }
            }
        }

        blindArea++;
    }

    private static void bfs(int i, int j) {
        queue.add(new XY(i, j));
        char color = draw[i][j];

        visited[i][j] = true;

        while (!queue.isEmpty()) {
            XY now = queue.poll();
            for (int idx = 0; idx < DIRECTION_MAX_INDEX; idx++) {
                int nextX = now.x + dx[idx];
                int nextY = now.y + dy[idx];

                if (!canMove(nextX, nextY)) continue; // 밖
                if (draw[nextX][nextY] != color) continue; // 색이 다른 경우
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new XY(nextX, nextY));
                }
            }
        }

        area++;
    }


    private static boolean canMove(int nextX, int nextY) {
        return 0 <= nextX && nextX < N && 0 <= nextY && nextY < N;
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        draw = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];
        queue = new LinkedList<>();
        area = 0; blindArea = 0;

        for (int i = 0; i < N; i++) {
            draw[i] = br.readLine().toCharArray();
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
