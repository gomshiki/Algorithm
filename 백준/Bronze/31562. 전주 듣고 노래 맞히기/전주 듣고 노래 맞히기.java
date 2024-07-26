import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정환이가  음을 아는 노래의 개수
        int M = Integer.parseInt(st.nextToken()); // 맞히기 시도할 노래 개수

        // 타이틀, 코드를 Map 에 담는다.
        String[] titles = new String[N];
        String[] codes = new String[N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int titleLength = Integer.parseInt(split[0]);
            titles[i] = split[1];

            StringBuilder sb = new StringBuilder();
            sb.append(split[2]).append(" ").append(split[3]).append(" ").append(split[4]);
            codes[i] = sb.toString();
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            int cnt = 0;
            String targetTitle = "";

            for (int j = 0; j < N; j++) {
                if (codes[j].equals(question)) {
                    cnt++;
                    targetTitle = titles[j];
                }

            }

            if (cnt >= 2) {
                System.out.println("?");
            }
            if (cnt == 1) {
                System.out.println(targetTitle);
            }
            if (cnt == 0) {
                System.out.println("!");
            }


        }
    }
}
