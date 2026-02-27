import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String sentence = br.readLine();
            if (sentence.equals(".")) {
                break;
            }
            char[] chars = sentence.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (char c : chars) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (isBalanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
