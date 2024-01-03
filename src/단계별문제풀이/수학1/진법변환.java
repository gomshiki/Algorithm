package 단계별문제풀이.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진법변환 {

    //B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {

        /**
         * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
         *
         * B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
         */

        // ex ZZZZZ 36 => 60466175 : 36진법 수 ZZZZZ 을 10진법으로 바꾸면 60466175
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        String target = s[0];

        long result = Long.parseLong(target, Integer.parseInt(s[1]));

        System.out.println(result);



    }

}
