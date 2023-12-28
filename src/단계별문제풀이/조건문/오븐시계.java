package 단계별문제풀이.조건문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2525번 오븐시계
// 현재시간 + 요리시간을 (x 시간 x 분)으로 표시
public class 오븐시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int afterHour = 0;
        int afterMinute = 0;

        String[] s = br.readLine().split(" ");
        int nowHour = Integer.parseInt(s[0]);
        int nowMinute = Integer.parseInt(s[1]);

        int takedTime = Integer.parseInt(br.readLine());

        int plusHour = (nowMinute + takedTime) / 60;
        int resultMin = (nowMinute + takedTime) % 60;

        if (nowHour + plusHour >= 24) {
            afterHour = (nowHour + plusHour) % 24;
            afterMinute = resultMin;
        } else {
            afterHour = (nowHour + plusHour);
            afterMinute = resultMin;
        }

        System.out.println(afterHour + " " + afterMinute);

    }

}
