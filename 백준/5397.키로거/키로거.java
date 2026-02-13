import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 백스페이스 -
        // 이동 < , >
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            sb.append(findPassword(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static String findPassword(String line) {
        ArrayDeque<Character> left = new ArrayDeque<>(line.length());
        ArrayDeque<Character> right = new ArrayDeque<>(line.length());
        for (char c : line.toCharArray()) {
            switch (c) {
                case '<' :
                    if (!left.isEmpty()) {
                        right.push(left.poll());
                    }
                    break;

                case '>' :
                    if (!right.isEmpty()) {
                        left.push(right.poll());
                    }
                    break;

                case '-' :
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;

                default:
                    if (isAlphaOrNum(c)) {
                        left.push(c);
                    }
            }
        }
        while (!right.isEmpty()) {
            left.push(right.pop());
        }

        return stackToString(left);
    }

    private static boolean isAlphaOrNum(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }

    private static String stackToString(ArrayDeque<Character> linkedList) {
        StringBuilder sb = new StringBuilder();
        for (char c : linkedList) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
