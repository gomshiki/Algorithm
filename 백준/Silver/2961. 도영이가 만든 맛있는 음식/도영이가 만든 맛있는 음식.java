import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받기
        N = Integer.parseInt(br.readLine());
        S = new int[N];  // 신 맛
        B = new int[N];  // 쓴 맛
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 1, 0, 0);  // (트리 깊이, 신맛, 쓴맛, 선택한 음식 개수)
        System.out.println(answer);

    }

    private static void DFS(int level, int s, int b, int selectedCount) {  //완탐

        if(level == N) {  //모든 조합 찾음
            if(selectedCount != 0 && Math.abs(s-b) < answer) //1개 이상 선택하고 쓴맛과 신맛의 차이가 지금까지 찾은 값보다 작다면
                answer = Math.abs(s-b); // 가장 작은 값으로 변경
            return;
        }


        DFS(level+1, s*S[level], b+B[level], selectedCount+1);
        DFS(level+1, s, b, selectedCount);

    }



}
