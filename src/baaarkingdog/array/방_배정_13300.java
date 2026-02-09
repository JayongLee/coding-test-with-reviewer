package baaarkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방_배정_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] room = new int[6][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            room[Y-1][S] += 1;
        }

        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                int people = room[i][j];
                if (people == 0) continue;
                count += room[i][j] % K != 0
                        ? room[i][j] / K + 1
                        : room[i][j] / K;
            }
        }

        System.out.println(count);
    }
}
