# [프로그래머스] 문자열 내 p와 y의 개수 - 12916

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12916)

### 성능 요약

메모리: 73 MB, 시간: 0.03 ms
코드 길이: N/A, 점수: N/A

### 분류

N/A

### 난이도

N/A

### 제출 일자

N/A

### 문제 설명

문제 설명 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다. 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다. 제한사항 문자열 s의 길이 : 50 이하의 자연수 문자열 s는 알파벳으로만 이루어져 있습니다. 입출력 예 s answer "pPoooyY" true "Pyy" false 입출력 예 설명 입출력 예 #1 'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다. 입출력 예 #2 'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다. ※ 공지 - 2021년 8월 23일 테스트케이스가 추가되었습니다. 0개의 제출새로고침제출 내역이 없습니다 Solution.java class Solution { boolean solution(String s) { boolean answer = true; // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. System.out.println("Hello Java"); return answer; } }xxxxxxxxxx910 1class Solution {2 boolean solution(String s) {3 boolean answer = true;4​5 s = s.toLowerCase();6 int pCount = 0; int yCount = 0;7 for (char c : s.toCharArray()) {8 if (c == 'p') pCount++;9 if (c == 'y') yCount++;10 }11​12 return pCount == yCount;13 }14} 실행 결과 실행 중지 채점을 시작합니다.정확성 테스트테스트 1 〉통과 (0.03ms, 73MB)테스트 2 〉통과 (0.04ms, 90.6MB)테스트 3 〉통과 (0.03ms, 86.6MB)테스트 4 〉통과 (0.04ms, 76.1MB)테스트 5 〉통과 (0.04ms, 76.5MB)테스트 6 〉통과 (0.03ms, 80.7MB)테스트 7 〉통과 (0.03ms, 78.7MB)테스트 8 〉통과 (0.03ms, 75.7MB)테스트 9 〉통과 (0.03ms, 77.1MB)테스트 10 〉통과 (0.04ms, 98.8MB)테스트 11 〉통과 (0.04ms, 76.8MB)테스트 12 〉통과 (0.04ms, 93.9MB)테스트 13 〉통과 (0.03ms, 81.8MB)테스트 14 〉통과 (0.04ms, 80.8MB)테스트 15 〉통과 (0.04ms, 86MB)테스트 16 〉통과 (0.04ms, 90.6MB)테스트 17 〉통과 (0.05ms, 73.1MB)테스트 18 〉통과 (0.03ms, 83.5MB)테스트 19 〉통과 (0.04ms, 80.6MB)테스트 20 〉통과 (0.03ms, 76.9MB)테스트 21 〉통과 (0.03ms, 82.2MB)테스트 22 〉통과 (0.03ms, 73.8MB)테스트 23 〉통과 (0.03ms, 78.7MB)테스트 24 〉통과 (0.04ms, 75.8MB)테스트 25 〉통과 (0.03ms, 79MB)테스트 26 〉통과 (0.04ms, 81.7MB)테스트 27 〉통과 (0.04ms, 94.6MB)테스트 28 〉통과 (0.04ms, 84.5MB)테스트 29 〉통과 (0.03ms, 76.9MB)테스트 30 〉통과 (0.03ms, 79.2MB)채점 결과정확성: 100.0합계: 100.0 / 100.0 질문하기 (57) 테스트 케이스 추가하기 다른 사람의 풀이 초기화 코드 실행 제출 후 채점하기

### 입력

문제 링크 참고

### 출력

문제 링크 참고
