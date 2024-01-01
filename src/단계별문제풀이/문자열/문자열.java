package 단계별문제풀이.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {
    // 문자열을 입력받아 첫 글자와 마지막 글자를 출력하는 프로그램
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            System.out.println(s.charAt(0) +""+ s.charAt(s.length()-1));
        }

    }
}
