package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class P1676 {

    /* Hint
        - 수학 문제이다. String으로 풀면 범위가 커지면 시간 초과가 발생한다.
        - 10 = 2*5이다. 곧 팩토리얼 안에 5의 개수만 찾으면 쉽게 해결된다.
        - 5의 개수는 5의 배수일 때, 5로 나뉘는 횟수이다.
     */

    // 팩토리얼 메서드
    static BigInteger factorial(int input){
        BigInteger output = new BigInteger("1"); // 팩토리얼의 시작은 1이다.
        for(int i=1; i<=input; i++){
            output = output.multiply(BigInteger.valueOf(i)); // 반복문 돌려서 곱셈
        }
        return output;
    }

    public static void main(String[] args) {

        int check = 0;

        // 입력
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());

        BigInteger output = factorial(input);

        String arr = output+"";

        for (int i=arr.length()-1; i>=0; i--){ // 배열의 마지막 인덱스부터 탐색
            String zero = String.valueOf(arr.charAt(i));

            if(!(zero.equals("0"))){
                break;
            }

            if (zero.equals("0")){
                check+=1;
            }
        }

        System.out.println(check);
    }
}
