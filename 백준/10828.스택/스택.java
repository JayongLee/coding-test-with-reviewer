import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int order = scanner.nextInt();
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < order; i++){
            String ord = scanner.next();
            switch (ord){
                case "push" :
                    stack.push(scanner.nextInt());
                    break;

                case "pop" :
                    if (!stack.empty()){
                        sb.append(stack.pop()).append('\n');
                    }
                    else sb.append(-1).append('\n');
                    break;

                case "top" :
                    if(stack.empty())
                        sb.append(-1).append('\n');
                    else sb.append(stack.peek()).append('\n');
                    break;

                case "empty" :
                    if(stack.empty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "size" :
                    sb.append(stack.size()).append('\n');
                    break;
            }


        }
        System.out.println(sb);

    }

}
