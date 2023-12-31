package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 과제안내신분 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] stuChk = new boolean[31];

        for (int i = 0; i < 28; i++) {
            stuChk[Integer.parseInt(br.readLine())] = true;
        }

        for (int i = 1; i < stuChk.length; i++) {
            if (!(stuChk[i])) {
                System.out.println(i);
            }
        }


    }

}
