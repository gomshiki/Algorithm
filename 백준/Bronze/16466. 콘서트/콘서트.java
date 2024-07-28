import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16466
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1차 티켓팅에서 팔린 티켓 수
        int N = Integer.parseInt(br.readLine());

        // 1차 티켓팅에서 팔린 티켓 번호 수
        int[] soldOutTicketNum = new int[N + 1];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            soldOutTicketNum[i + 1] = Integer.parseInt(split[i]);
        }

        // 오름차순 정렬
        Arrays.sort(soldOutTicketNum);


        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt++;
            if (cnt != soldOutTicketNum[i]) {
                System.out.println(cnt);
                return;
            }
        }

        System.out.println(cnt + 1);

    }
}
