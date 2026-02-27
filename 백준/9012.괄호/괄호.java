import java.util.*;
public class Main {
    public static boolean check (String s){
        Stack<Character> stack = new Stack<>();
        boolean b = true;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '(':
                    stack.push(c);
                    break;

                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    else {
                        char check = stack.pop();
                        if (check != '('){
                            return false;
                        }
                    }
                    break;
            }
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            if(check(scanner.next()))
                System.out.println("YES");
            else System.out.println("NO");
        }




    }
}
