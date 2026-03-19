// package baaarkingdog.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, ans;
    private static boolean[] isUsedRow, isUsedUpperCross, isUsedDownCross;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        isUsedRow = new boolean[N];
        isUsedUpperCross = new boolean[N * 2];
        isUsedDownCross = new boolean[N * 2];
        backtrack(0);
        System.out.println(ans);
    }

    private static void backtrack(int col) {
        if (col == N) {
            ans++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isUsedRow[row] || isUsedUpperCross[row + col] || isUsedDownCross[col - row + N - 1])
                continue;

            isUsedRow[row] = true; isUsedUpperCross[row + col] = true; isUsedDownCross[col - row + N - 1] = true;
            backtrack(col + 1);
            isUsedRow[row] = false; isUsedUpperCross[row + col] = false; isUsedDownCross[col - row + N - 1] = false;
        }

    }
}
