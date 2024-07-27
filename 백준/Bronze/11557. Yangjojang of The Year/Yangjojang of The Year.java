import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11557
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int schoolCnt = Integer.parseInt(br.readLine());

            PriorityQueue<SchoolInfo> pq = new PriorityQueue<>();
            for (int j = 0; j < schoolCnt; j++) {
                String[] split = br.readLine().split(" ");

                SchoolInfo schoolInfo = new SchoolInfo(Integer.parseInt(split[1]), split[0]);
                pq.add(schoolInfo);
            }

            sb.append(pq.poll().name).append("\n");
            pq.clear();
        }

        System.out.println(sb.toString());
    }

    static class SchoolInfo implements Comparable<SchoolInfo> {
        int alcohol;
        String name;

        public SchoolInfo(int alcohol, String name) {
            this.alcohol = alcohol;
            this.name = name;
        }

        @Override
        public int compareTo(SchoolInfo s) {
            return s.alcohol - this.alcohol;
        }
    }
}
