import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 후보 수
        int dasomVote = Integer.parseInt(br.readLine());

        int cnt = 0;

        if (N != 1) { // 다솜이 혼자 후보가 아닐때만 수행
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 정렬
            for (int i = 0; i < N-1; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }

            while (true) {
                Integer maxVote = pq.poll(); // 항상 큰수만 뽑힘
                if(dasomVote > maxVote){
                    break;
                }
                maxVote--; // 가장 큰 후보 투표수 -1
                dasomVote++; // 다솜 투표수 +1
                cnt++; // 매수 횟수 +1
                pq.add(maxVote);


            }
        }

        System.out.println(cnt);

    }
}
