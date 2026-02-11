import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.next().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            if (!map.containsKey(word.charAt(i))){
                map.put(word.charAt(i), 1);
            }
            else {
                int k = map.get(word.charAt(i));
                map.replace(word.charAt(i), k + 1);
            }
        }

        int max = 0;
        int index = 0;

        for (int i = 0; i < word.length(); i++){

            int k = map.get(word.charAt(i));
            if (max < k){
                max = k;
                index = i;
            }

        }
        char result = word.charAt(index);
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(index) != word.charAt(i)) {
                if (max == map.get(word.charAt(i))) {
                    result = '?';
                }
            }
        }

        System.out.println(result);










    }
}
