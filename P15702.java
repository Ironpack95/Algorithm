package baekjoon;

import java.util.Scanner;

public class P15702 {
    /* Hint
        - 응시자의 수는 입력받는 총횟수이다.
        - 정렬을 위해 각 값의 기준을 정해야된다. 그래야지 첫 정렬이 가능하다.
        - 최소값 : 범위의 최대값 +1 /  최대값 : 범위의 최소값 -1
        - 틀린 경우는 연산할 필요가 없다.
     */

    // 숫자 추출 메서드
    static int[] collectNum(String input){

        String[] arr = input.split(" ");
        int[] output = new int[arr.length];

        for(int i=0; i< arr.length; i++){
            output[i] = Integer.parseInt(arr[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        int n, m; // n : 문제수, m : 사람수 - 총반복수
        int[] score;
        int num = 100001, max = 0; // 정렬을 위한 기준값 설정
        int[][] rank;

        // 1. N, M 입력
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();

        int[] output = collectNum(firstLine);
        n = output[0];
        m = output[1];

        rank = new int[m][2];

        // 2. 배점 입력 및 배열 생성
        String secondLine = scan.nextLine();
        score = collectNum(secondLine); // [0] : 수험번호, 다음 인덱스부터 채점결과

        // 3. 학생별 점수 받으면서 최대값 저장
        for (int i = 0; i < m; i++) {
            String input = scan.nextLine();
            String[] inputArr = input.split(" "); // 인자값을 기준으로 문자열을 구분해서 문자열 배열로 반환한다.

            // 수험 번호 저장
            rank[i][0] = Integer.parseInt(inputArr[0]);

            // 총점 저장 [i][1]
            for (int j = 1; j < inputArr.length; j++) {
                if (inputArr[j].equalsIgnoreCase("O")) {
                    rank[i][1] += score[j - 1]; // 수험번호 제외
                }
            }

            // 최대값을 비교해서 정보 저장
            if (rank[i][1] > max) {
                num = rank[i][0];
                max = rank[i][1];
            }
        }

        // 4. 배열 확인해서 수험번호가 가장 낮은 걸 추출
        for(int i=0; i<rank.length; i++){
            if(rank[i][1] == max && num > rank[i][0]){
                num = rank[i][0];
            }
        }

        // 5. 출력
        System.out.printf("%d %d", num, max);
    }
}
