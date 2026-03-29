import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int row;
    private static int col;
    private static int count;

    public static void main(String[] args) throws IOException {
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        row = Integer.parseInt(nums[1]);
        col = Integer.parseInt(nums[2]);

        onePiece();
    }


    private static void onePiece() {
        if (N == 0) {
            System.out.println(count);
            return;
        }
        int half = (int) Math.pow(2, N-1);
        N -= 1;
        if (row < half) {
            if (col < half) {
                // 1사분면
                onePiece();
            } else {
                col -= half;
                count += half * half;
                onePiece();
            }
        } else {
            row -= half;
            if (col < half) {
                count += half * half * 2;
                onePiece();
            } else {
                col -= half;
                count += half * half * 3;
                onePiece();
            }
        }
    }
}
