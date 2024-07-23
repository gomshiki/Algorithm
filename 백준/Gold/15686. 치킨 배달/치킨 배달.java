import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> chicken;
    static List<int[]> house;
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    house.add(new int[]{i, j});
                } else if (value == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chicken.size()];
        backtracking(0, 0);
        System.out.println(minDistance);
    }

    static void backtracking(int idx, int cnt) {
        if (cnt == M) {
            int distance = calculateDistance();
            minDistance = Math.min(minDistance, distance);
            return;
        }

        if (idx >= chicken.size()) return;

        selected[idx] = true;
        backtracking(idx + 1, cnt + 1);

        selected[idx] = false;
        backtracking(idx + 1, cnt);
    }

    static int calculateDistance() {
        int totalDistance = 0;
        for (int[] h : house) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    int[] c = chicken.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }
            }
            totalDistance += minDist;
        }
        return totalDistance;
    }
}