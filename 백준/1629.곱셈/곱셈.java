import java.util.*;
import java.io.*;

class Main {
  static long C;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    C = Long.parseLong(st.nextToken());

    System.out.println(pow(A, B));
  }

  static long pow(long a, long exponent) {
    if (exponent == 1) {
      return a % C;
    }
    
    long temp = pow(a, exponent / 2);

    if (exponent % 2 == 1) {
      return (temp * temp % C) * (a % C) % C;
    }
        
    return temp * temp % C;
  }
}
