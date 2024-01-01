package 단계별문제풀이.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그대로출력하기 {

    // 입력받은 그대로 출력하는 프로그램
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "";


        while ((s = br.readLine()) != null) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());



    }

}
