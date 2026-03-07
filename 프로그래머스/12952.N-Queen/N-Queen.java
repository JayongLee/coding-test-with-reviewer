import java.util.ArrayList;

class Solution {
    
    private static int N, ans;
    public int solution(int n) {
        N = n;
        ArrayList<Integer> queen = new ArrayList<>();
        backtrack(-1, 1, queen);
        
        return ans;
    }
    
    private static void backtrack(int before, int count, ArrayList<Integer> queen) {
        if (queen.size() == N) {
            ans++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (i == before - 1 || i == before || i == before + 1 || queen.contains(i)) {
                continue;
            }
            if (isVisitedCross(i, count, queen)) {
            	continue;
            }
            ArrayList<Integer> copyQueen = new ArrayList<>(queen);
            copyQueen.add(i);
            backtrack(i, count + 1, copyQueen);
        }
        
    }
    
    private static boolean isVisitedCross(int now, int count, ArrayList<Integer> queen) {
    	for (int i = 0; i < queen.size(); i++) {
    		int upCross = queen.get(i) - (count - (i + 1));
    		int downCross = queen.get(i) + (count - (i + 1));
    		if (now == upCross || now == downCross)
    			return true;
    	}
    	return false;
    }
}
