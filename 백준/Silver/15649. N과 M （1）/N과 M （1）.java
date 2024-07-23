import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, r;
    static boolean[] visited;
    static int[] answer;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);

        visited = new boolean[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i + 1;
        }
        result = new int[r];
        perm(0);
        System.out.println(sb);

    }

    static void perm(int depth){
        if (depth == r){
            for (int i = 0; i < r; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }else{
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    result[depth] = answer[i];
                    perm(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
