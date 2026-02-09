package baaarkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 애너그램만들기_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        for (char c : word1.toCharArray()) {
            if (word2.contains(String.valueOf(c))) {
                word1 = word1.replaceFirst(String.valueOf(c), "");
                word2 = word2.replaceFirst(String.valueOf(c), "");
            }
        }
        System.out.println(word1.length() + word2.length());
    }
}
