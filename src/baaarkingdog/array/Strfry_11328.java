package baaarkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Strfry_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String origin = st.nextToken();
            String strfry = st.nextToken();
            char[] chars = origin.toCharArray();
            for (char c : chars) {
                if (strfry.contains(String.valueOf(c))) {
                    strfry = strfry.replaceFirst(String.valueOf(c), "");
                } else {
                    break;
                }
            }
            if (strfry.isEmpty()) {
                sb.append("Possible").append("\n");
            } else {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }
}
