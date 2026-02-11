import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k1=0, k2=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.equals("KBS1")) k1=i;
            else if(str.equals("KBS2")) k2=i;
        }
        if(k1>k2) k2++;
        for(int i=0;i<k1;i++) bw.write("1");
        for(int i=0;i<k1;i++) bw.write("4");
        for(int i=0;i<k2;i++) bw.write("1");
        for(int i=0;i<k2-1;i++) bw.write("4");

        br.close();
        bw.close();
    }
}
