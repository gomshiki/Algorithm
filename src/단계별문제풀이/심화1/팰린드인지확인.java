package 단계별문제풀이.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 팰린드인지확인 {

    /**
     * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
     *
     * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
     *
     * level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");

        String[] strChk = new String[s.length];


        for (int i = 0; i < s.length; i++) {
            strChk[i] = s[s.length - (i + 1)];
        }

        for (int i = 0; i < s.length; i++) {

            if (!strChk[i].equals(s[i])) {
                System.out.println(0);
                break;
            }

            if (i == s.length-1) {
                System.out.println(1);
            }

        }


    }
}
