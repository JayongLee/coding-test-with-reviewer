# [프로그래머스] N-Queen - 12952

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12952)

### 성능 요약

메모리: 89.4 MB, 시간: 0.03 ms
코드 길이: N/A, 점수: N/A

### 분류

N/A

### 난이도

N/A

### 제출 일자

N/A

### 문제 설명

문제 설명 가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다. 예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다. 체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요. 제한사항 퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다. n은 12이하의 자연수 입니다. 입출력 예 n result 4 2 입출력 예 설명 입출력 예 #1 문제의 예시와 같습니다. 2개의 제출새로고침제출일시언어채점 내역2025-08-24 15:07:03Java정답100 / 1002025-08-24 13:08:08Java오답27.3 / 1001 Solution.java import java.util.ArrayList; class Solution { private static int N, ans; public int solution(int n) { N = n; ArrayList<Integer> queen = new ArrayList<>(); backtrack(-1, 1, queen); return ans; } private static void backtrack(int before, int count, ArrayList<Integer> queen) { if (queen.size() == N) { ans++; return; } for (int i = 1; i <= N; i++) { if (i == before - 1 || i == before || i == before + 1 || queen.contains(i)) { continue; } if (isVisitedCross(i, count, queen)) { continue; } ArrayList<Integer> copyQueen = new ArrayList<>(queen); copyQueen.add(i); backtrack(i, count + 1, copyQueen); } } private static boolean isVisitedCross(int now, int count, ArrayList<Integer> queen) { for (int i = 0; i < queen.size(); i++) { int upCross = queen.get(i) - (count - (i + 1)); int downCross = queen.get(i) + (count - (i + 1)); if (now == upCross || now == downCross) return true; } return false; } }​x43 1import java.util.ArrayList;2​3class Solution {4 5 private static int N, ans;6 public int solution(int n) {7 N = n;8 ArrayList<Integer> queen = new ArrayList<>();9 backtrack(-1, 1, queen);10 11 return ans;12 }13 14 private static void backtrack(int before, int count, ArrayList<Integer> queen) {15 if (queen.size() == N) {16 ans++;17 return;18 }19 20 for (int i = 1; i <= N; i++) {21 if (i == before - 1 || i == before || i == before + 1 || queen.contains(i)) {22 continue;23 }24 if (isVisitedCross(i, count, queen)) {25 continue;26 }27 ArrayList<Integer> copyQueen = new ArrayList<>(queen);28 copyQueen.add(i);29 backtrack(i, count + 1, copyQueen);30 }31 32 }33 34 private static boolean isVisitedCross(int now, int count, ArrayList<Integer> queen) {35 for (int i = 0; i < queen.size(); i++) {36 int upCross = queen.get(i) - (count - (i + 1));37 int downCross = queen.get(i) + (count - (i + 1));38 if (now == upCross || now == downCross)39 return true;40 }41 return false;42 }43} 실행 결과 실행 중지 같은 코드로 채점한 결과가 있습니다.정확성 테스트테스트 1 〉통과 (0.03ms, 89.4MB)테스트 2 〉통과 (0.05ms, 73MB)테스트 3 〉통과 (0.05ms, 86.1MB)테스트 4 〉통과 (0.37ms, 73.1MB)테스트 5 〉통과 (1.01ms, 80.4MB)테스트 6 〉통과 (2.08ms, 75.5MB)테스트 7 〉통과 (4.39ms, 92.3MB)테스트 8 〉통과 (10.15ms, 97.4MB)테스트 9 〉통과 (27.11ms, 91.6MB)테스트 10 〉통과 (78.60ms, 93.8MB)테스트 11 〉통과 (321.25ms, 123MB)채점 결과정확성: 100.0합계: 100.0 / 100.0 질문하기 (17) 테스트 케이스 추가하기 다른 사람의 풀이 초기화 코드 실행 제출 후 채점하기

### 입력

문제 링크 참고

### 출력

문제 링크 참고
