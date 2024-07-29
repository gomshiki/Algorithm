import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1524
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 : T
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 빈 문자열 처리
            br.readLine();

            String[] split = br.readLine().split(" ");

            int N = Integer.parseInt(split[0]); // 세준 병사 수 : N
            int M = Integer.parseInt(split[1]); // 세비 병사 수 : M
            
            // 세준 병사들 중 힘이 센 병사를 구한다.
            st = new StringTokenizer(br.readLine(), " ");
            int SMax = -1;
            for (int j = 0; j < N; j++) {
                int S = Integer.parseInt(st.nextToken());

                if (SMax < S) SMax = S;
            }

            // 세빈의 병사들 중 힘이 센 병사를 구한다.
            st = new StringTokenizer(br.readLine(), " ");
            int BMax = -1;
            for (int j = 0; j < M; j++) {
                int B = Integer.parseInt(st.nextToken());
                if(BMax < B) BMax = B;
            }

            if (SMax > BMax) {
                sb.append("S").append("\n");
            } else if (SMax < BMax) {
                sb.append("B").append("\n");
            } else {
                sb.append("S").append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}
