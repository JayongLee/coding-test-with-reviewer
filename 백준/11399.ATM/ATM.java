import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] line = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line);
		
		int subSum = 0;
		int totalSum = 0;
		for (int i = 0; i < N; i++) {
			int n = line[i];
			subSum += n;
			totalSum += subSum;
		}
		System.out.print(totalSum);
	}
}
