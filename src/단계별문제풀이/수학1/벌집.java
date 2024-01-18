package 단계별문제풀이.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {

    public static void main(String[] args) throws IOException {

        // 1번방에서 N번방까지 지나는 방의 개수 구하기 순서는 벌집중아에서 시계방향으로 방번호를 매김
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        // 2 ~ 7  :  1 | 2,3,4,5,6,7 : 6개
        // 8 ~ 19 :  2 | 8,9,10,11,12,13,14,15,16,17,18,19 : 12개
        // 20 ~ 37 : 3 | 20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37 : 18개
        // 38 ~ 61 : 4 | 38 ... 61 : 24개
        // 갯수 : 6의 배수

        int count = 1 ; // 겹의 갯수
        int range = 2 ; // 최소 범위

        if (N == 1) {

            System.out.println(1);

        } else {

            while (range <= N) {

                range = range + (6 * count); // 2 + 6 = 8, 8 + 6*2 = 18,
                count++;

            }
            System.out.println(count);

        }
    }

}
