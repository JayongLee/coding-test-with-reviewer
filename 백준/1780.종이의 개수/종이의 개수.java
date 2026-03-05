import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] map;
    private static int zeroCount, minusCount, plusCount;
    private static final int[] DX = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    private static final int[] DY = {0, 0, 0, 1, 1, 1, 2, 2, 2};

    public static void main(String[] args) throws IOException {
        init();
        recursive(N, 0, 0);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        zeroCount = 0; minusCount = 0; plusCount = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void recursive(int size, int startX, int startY) {
        int baseNum = map[startX][startY];
        if (size == 1) {
            countNum(baseNum);
            return;
        }

        if (isFillSame(size, startX, startY)) {
            countNum(baseNum);
        } else {
            int divideSize = size / 3;
            for (int i = 0; i < 9; i++) {
                recursive(divideSize, startX + DX[i] * divideSize, startY + DY[i] * divideSize);
            }
        }
    }

    private static void countNum(int num) {
        switch (num) {
            case -1 :
                minusCount++;
                break;

            case 0 :
                zeroCount++;
                break;

            case 1 :
                plusCount++;
                break;
        }
    }

    private static boolean isFillSame(int size, int startX, int startY) {
        int base = map[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (base != map[i][j])
                    return false;
            }
        }
        return true;
    }
}
