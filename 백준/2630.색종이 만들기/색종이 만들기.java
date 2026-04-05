import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int blue;
    private static int white;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkColor(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void checkColor(int x, int y, int size) {
        if (isOneColor(x, y, size)) {
            if (map[x][y] == 1) {
                blue += 1;
            } else {
                white += 1;
            }
            return;
        }
        int halfSize = size / 2;
        // 1사분면
        checkColor(x, y, halfSize);
        // 2사분면
        checkColor(x + halfSize, y, halfSize);
        // 3사분면
        checkColor(x, y + halfSize, halfSize);
        // 4사분면
        checkColor(x + halfSize, y + halfSize, halfSize);
    }

    private static boolean isOneColor(int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}
