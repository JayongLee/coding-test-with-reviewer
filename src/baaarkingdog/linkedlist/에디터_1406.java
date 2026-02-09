package baaarkingdog.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> editor = new LinkedList<>();

        for (char c : line.toCharArray()) {
            editor.add(c);
        }
        int cursor = editor.size();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "P" :
                    char c = st.nextToken().charAt(0);
                    editor.add(cursor++, c);
                    break;

                case "L" :
                    if (cursor == 0) break;
                    cursor--;
                    break;

                case "D" :
                    if (cursor == editor.size()) break;
                    cursor++;
                    break;

                case "B" :
                    if (cursor == 0) break;
                    editor.remove(cursor - 1);
                    cursor--;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < editor.size(); i++) {
            sb.append(editor.get(i));
        }
        System.out.println(sb); // 출력11
    }
}
