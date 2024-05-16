import java.io.*;
import java.util.*;

public class Main {

    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N, K);
        }

    }

    static void bfs(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next ;

                if (i == 0 ) {
                    next = node + 1;
                }else if(i == 1 ){
                    next = node -1;
                }else{
                    next = node * 2;
                }

                if(next == K){
                    System.out.println(visited[node]);
                    return;
                }

                if(next >= 0 && next < visited.length && visited[next] == 0){
                    queue.add(next);
                    visited[next] = visited[node] + 1;
                }

            }


        }


    }
}
