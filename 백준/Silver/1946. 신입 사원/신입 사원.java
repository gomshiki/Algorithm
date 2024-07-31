import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine()); // 지원자 수

            TreeMap<Integer, Integer> applicants = new TreeMap<>();

            // 면접 성적순으로 정렬한 Map
            for (int j = 0; j < n; j++) {
                String[] split = br.readLine().split(" ");
                applicants.put(Integer.parseInt(split[1]), Integer.parseInt(split[0]));
            }

            // 합격자 수
            int cnt = 1; // 면접 1등은 바로 포함
            int minScore = applicants.get(1);
            for (int j = 2; j <= n; j++) {
                if (applicants.get(j) < minScore) { // 서류 성적이 면접 1등 기준보다 등수가 높으면
                    cnt++;
                    minScore = applicants.get(j);
                }
            }
            sb.append(cnt).append("\n");
            
        }
        System.out.println(sb.toString());
    }


}
