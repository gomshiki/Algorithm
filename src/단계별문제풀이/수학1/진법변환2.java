package 단계별문제풀이.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진법변환2 {

    // 10진법 수 N을 입력받아 B 진법으로 바꿔 출력하는 프로그램
    // 10진법을 넘어가는 진법은 숫자 대신 알파벳 대문자를 사용
    // A: 10, B: 11, .. F:15, Y:35, Z:35
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();


        while (N > 0) {
            // ASCII 코드 character : 10 진수
            // '0' : 80
            // '1' : 81
            // ...
            // '9' : 89
            // 'A' : 65
            // 'Z' : 90

            if (N % B < 10) {
                sb.append((char)('0' + N % B));
            } else {
                sb.append((char) ('A' + N % B - 10));

            }
            N /= B;
        }

        System.out.println(sb.reverse());
    }

}
