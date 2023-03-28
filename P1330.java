package baekjoon;

import java.util.Scanner;

public class P1330 {

    public static void main(String[] args) {

        int x, y;

        Scanner scan = new Scanner(System.in);

        x = scan.nextInt();
        y = scan.nextInt();

        String result = (x > y) ? ">" : (x<y) ? "<" : "==";
        System.out.println(result);
    }
}
