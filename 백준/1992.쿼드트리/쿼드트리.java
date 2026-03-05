import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] video;
    private static int N;
    private static final int[] DX = {0, 0, 1, 1};
    private static final int[] DY = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(zip(N, 0, 0));
    }

    private static String zip(int size, int startX, int startY) {
        int base = video[startX][startY];
        if (size == 1) {
            return String.valueOf(base);
        }
        if (isFillSame(size, startX, startY, base)) {
            return String.valueOf(base);
        }

        int divideSize = size / 2;
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < DX.length; i++) {
            sb.append(
                    zip(divideSize, startX + DX[i] * divideSize, startY + DY[i] * divideSize)
            );
        }
        sb.append(")");
        return sb.toString();
    }

    private static boolean isFillSame(int size, int startX, int startY, int base) {
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (video[i][j] != base)
                    return false;
            }
        }
        return true;
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                video[i][j] = line[j] - '0';
            }
        }
    }

}
