# [프로그래머스] 주식가격 - 42584

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42584)

### 성능 요약

메모리: 79.9 MB, 시간: 0.04 ms
코드 길이: N/A, 점수: N/A

### 분류

N/A

### 난이도

N/A

### 제출 일자

N/A

### 문제 설명

문제 설명 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요. 제한사항 prices의 각 가격은 1 이상 10,000 이하인 자연수입니다. prices의 길이는 2 이상 100,000 이하입니다. 입출력 예 prices return [1, 2, 3, 2, 3] [4, 3, 1, 1, 0] 입출력 예 설명 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다. 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다. 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다. 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다. 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다. ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다. 1개의 제출새로고침제출일시언어채점 내역2025-03-24 12:16:38Java오답6.7 / 1001 Solution.java class Solution { public int[] solution(int[] prices) { int[] answer = new int[prices.length]; for (int i = 0; i < prices.length; i++) { for (int j = 0; j < i; j++) { if (prices[j] <= prices[i]) { answer[j] += 1; } } } return answer; } }​x10 1import java.util.*;2​3class Solution {4 public int[] solution(int[] prices) {5 Deque<Integer> stack = new ArrayDeque<>();6 7 int N = prices.length;8 9 int[] answer = new int[N];10 for (int i = 0; i < N; i++) {11 int next = prices[i];12 while (!stack.isEmpty()) {13 if (prices[stack.peek()] > next) { // 가격이 떨어짐14 int idx = stack.pop();15 answer[idx] = i - idx;16 } else {17 break;18 }19 }20 stack.push(i);21 }22 23 while (!stack.isEmpty()) {24 int idx = stack.pop();25 answer[idx] = N - (idx + 1);26 }27 return answer;28 }29} 실행 결과 실행 중지 채점을 시작합니다.정확성 테스트테스트 1 〉통과 (0.04ms, 79.9MB)테스트 2 〉통과 (0.20ms, 87.4MB)테스트 3 〉통과 (0.68ms, 83.9MB)테스트 4 〉통과 (1.14ms, 81.3MB)테스트 5 〉통과 (0.98ms, 74.8MB)테스트 6 〉통과 (0.16ms, 90.5MB)테스트 7 〉통과 (0.83ms, 79.5MB)테스트 8 〉통과 (0.87ms, 76.1MB)테스트 9 〉통과 (0.20ms, 81.4MB)테스트 10 〉통과 (0.91ms, 85.6MB)효율성 테스트테스트 1 〉통과 (25.91ms, 75.5MB)테스트 2 〉통과 (21.33ms, 67.4MB)테스트 3 〉통과 (28.74ms, 73.9MB)테스트 4 〉통과 (25.80ms, 74.7MB)테스트 5 〉통과 (19.49ms, 76.2MB)채점 결과정확성: 66.7효율성: 33.3합계: 100.0 / 100.0 질문하기 (176) 테스트 케이스 추가하기 다른 사람의 풀이 초기화 코드 실행 제출 후 채점하기

### 입력

문제 링크 참고

### 출력

문제 링크 참고
