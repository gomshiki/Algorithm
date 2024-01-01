package 단계별문제풀이.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자와문자열 {

    // 단어 S와 정수 i가 주어졌을때, S의 i번째 글자를 출력하는 프로그램
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(i-1));

    }

}
