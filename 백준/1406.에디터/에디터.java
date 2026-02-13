import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static Integer M;
    private static BufferedReader br;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        M = Integer.parseInt(br.readLine());

        stack = init(line);

        executeCommand();

        System.out.println(stack.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }

    private static void executeCommand() throws IOException {
        Stack<Character> tmpStack = new Stack<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            String command = line.nextToken();
            switch (command) {
                case "L" :
                    if (!stack.isEmpty()) {
                        Character pop = stack.pop();
                        tmpStack.add(pop);
                    }
                    break;

                case "D" :
                    if (!tmpStack.isEmpty()) {
                        stack.push(tmpStack.pop());
                    }
                    break;

                case "B" :
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;

                case "P" :
                    String next = line.nextToken();
                    stack.push(next.charAt(0));
                    break;
            }
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    private static Stack<Character> init(String line) {
        Stack<Character> stack = new Stack<>();
        for (char c : line.toCharArray()) {
            stack.push(c);
        }
        return stack;
    }
}
