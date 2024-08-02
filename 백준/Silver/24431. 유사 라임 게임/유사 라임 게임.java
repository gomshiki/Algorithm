import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * L : 단어 길이
 * n : 길이가 L인 단어의 개수
 * F : 공통 접미사 길이 (문제에서 F 이상이면 "유사 라임")
 * F <= 2 인 경우  ex) WALK, BULK, TALK, MILK
 * F = 3 인 경우 ex) WALK, TALK
 * F >= 4 인 경우 없음
 * <p>
 * 최대 유사 라임쌍 개수를 구하세요
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, L, F;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());

            // 문자열
            String[] words = br.readLine().split(" ");
            Arrays.sort(words);

            // 방문체크
            boolean[] used = new boolean[n];
            int cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (words[i].substring(L - F).equals(words[j].substring(L - F)) && !used[i] && !used[j]) {
                        used[i] = true;
                        used[j] = true;
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
