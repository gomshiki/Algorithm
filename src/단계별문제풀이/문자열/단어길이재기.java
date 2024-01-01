package 단계별문제풀이.문자열;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어길이재기 {

    // 알파벳으로 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(s.length());
    }

}
