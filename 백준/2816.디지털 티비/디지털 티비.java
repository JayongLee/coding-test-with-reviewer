import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] chanels = new String[N];
        int kbs_1 = 0;
        int kbs_2 = 0;
        for (int i = 0; i < N; i++) {
            String channel = br.readLine();
            if (channel.equals("KBS1")) {
                kbs_1 = i;
            } else if (channel.equals("KBS2")) {
                kbs_2 = i;
            }
            chanels[i] = channel;
        }
        // 1. 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
        // 2. 화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
        // 3. 현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
        // 4.현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)
        StringBuilder sb = new StringBuilder();
        if (kbs_2 < kbs_1) {
            kbs_2++;
        }
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";

        sb.append(one.repeat(kbs_1));
        sb.append(four.repeat(kbs_1));
        if (kbs_2 != 1) {
            sb.append(one.repeat(kbs_2));
            sb.append(four.repeat(kbs_2 - 1));
        }
        System.out.println(sb.toString());
    }
}
