package baekjoon;

import java.util.Scanner;

public class P1769 {
    public static void main(String[] args) {
        /* Hint
            - 자리수가 100만이다 == 문자열 길이가 100만이다.
            - String으론 100만을 받을 수 있다. int, long 등 다른 자료형은 범위를 초과한다.
            - 100만 : 1,000,000,000,000,000 (15자리임) 대신 문자열의 길이는 15이다.
         */

        // 1. 변수 선언
        String input;
        int x = 0;
        String y = "NO";
        int circle = 0; // 변환 과정의 횟수

        Scanner scaner = new Scanner(System.in);
        input = scaner.nextLine();

        // 2-1. 변환 과정 횟수 구하기
        if(input.length() == 1){ // 문자열의 길이가 1인 경우
            x+=input.charAt(0)-48; // 문자열에서 정수 추출
        }else { // 문자열이 길어질 경우
            ++circle; // 반복 횟수 증가
            while(input.length() != 1){
                x = 0;
                for (int i=0; i<input.length(); i++){
                    if(input.charAt(i) != 48){ // 0이 아닌 경우에만 더해주는게 효율적
                        x+=input.charAt(i)-48;
                    }
                }
                input = x+"";

                if(x>9){
                    ++circle; // 더한 값이 2자리 이상이면 횟수 증가
                }
            }
        }

        // 2-2. 3의 배수인지 확인
        if(x%3==0){
            y = "YES";
        }

        // 3. 출력
        System.out.println(circle);
        System.out.print(y);
    }
}