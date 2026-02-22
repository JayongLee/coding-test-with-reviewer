import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nextPush = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Set<Integer> popSet = new HashSet<>();
        while (count < N) {
            count++;
            int seqNum = Integer.parseInt(br.readLine());
            if (popSet.contains(seqNum)) {
                System.out.println("NO");
                return;
            }
            if (stack.contains(seqNum)) {
                while (true) {
                    int pop = stack.pop();
                    sb.append("-").append("\n");
                    popSet.add(pop);
                    if (pop == seqNum) {
                        break;
                    }
                }
            } else {
                while (nextPush < seqNum) {
                    stack.push(nextPush++);
                    sb.append("+").append("\n");
                }
                popSet.add(nextPush++);
                sb.append("+\n-\n");
            }
        }
        System.out.println(sb);
    }
}
