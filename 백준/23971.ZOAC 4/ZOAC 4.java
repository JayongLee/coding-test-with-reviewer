import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // row
        int H = Integer.parseInt(st.nextToken());
        // col
        int W = Integer.parseInt(st.nextToken());
        // 세로
        int N = Integer.parseInt(st.nextToken());
        // 가로
        int M = Integer.parseInt(st.nextToken());

        int row_max = (H-1) / (N+1) + 1;
        int col_max = (W-1) / (M+1) + 1;
        System.out.println(row_max * col_max);
    }
}
