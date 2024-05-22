import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited = new boolean[100001];
    static int[] time = new int[100001];
    static int nextNode = 0;
    static int[] countArray = new int[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(b.readLine());

        int firstNode = Integer.parseInt(st.nextToken());
        int targetNode = Integer.parseInt(st.nextToken());

        if (firstNode >= targetNode) {
            System.out.println((firstNode - targetNode) + "\n1");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(firstNode);
        visited[firstNode] = true;
        time[firstNode] = 1;
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            if(minTime < time[nowNode]) {
                System.out.println(minTime);
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 3; i++) {

                if (i == 0) {
                    nextNode = nowNode + 1;
                } else if (i == 1) {
                    nextNode = nowNode - 1;
                } else {
                    nextNode = 2 * nowNode;
                }

                if (nextNode == targetNode) {
                    minTime = time[nowNode];
                    count++;
                }

                if (nextNode >= 0 && nextNode < 100001) {
                    if (time[nextNode] == 0 || time[nextNode] == time[nowNode] + 1) {
                        time[nextNode] = time[nowNode] + 1;
                        queue.add(nextNode);
                    }
                }


            }

        }


    }
}
