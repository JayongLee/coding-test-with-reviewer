import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> ansList;
    
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		ansList = new ArrayList<>();
		backtrack(0, new ArrayList<Integer>(), visited);
		
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> arr : ansList) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static void backtrack(int count, ArrayList<Integer> sequence, boolean[] visited) {
		if (count == M) {
			ansList.add(sequence);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				ArrayList<Integer> copyList = new ArrayList<Integer>(sequence);
				copyList.add(i);
				boolean[] copyVisited = Arrays.copyOf(visited, visited.length);
				copyVisited[i] = true;
				backtrack(count + 1, copyList, copyVisited);
			}
 		}
	}

}
