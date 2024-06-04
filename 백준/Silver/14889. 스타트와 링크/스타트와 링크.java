import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int minValue = Integer.MAX_VALUE;    // 최솟값 (Integer의 가장 최댓값을 넣어줌)
    public static int[][] iceRink;                     // 아이스링크장의 능력치 값 저장 배열
    public static int N;                              //축구를 하기 위해 모인 사람들
    public static boolean[] visit;                           //방문여부 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //숫자의 개수
        iceRink = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++){ //아이스링크 능력치 값 넣기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                iceRink[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        createTeam(0,0);

        System.out.println(minValue);

    }

    //해당 인덱스와 팀이 만들어진 정도를 파라미터로 받음
    public static void createTeam(int index, int fullDegree) {
        if(fullDegree >= N/2){ //팀 조합이 완성되었으면
            /*
                만들어진 팀과 아직 만들어지지 않은 팀을 나누어
                각각의 팀의 점수를 구한 뒤 최솟값을 찾음.
             */
            gap();
            return;
        }

        for(int i = index; i < N; i++){
            //방문하지 않은 경우는 방문으로 바꾼다.
            if(!visit[i]){
                visit[i] = true; //방문으로 바꿈
                createTeam(i+1, fullDegree+1); //재귀 호출
                visit[i] = false; //재귀가 끝나면 비방문으로 바꿈
            }
        }
    }

    //두 팀의 능력치 차이를 계산하는 메소드
    static void gap(){
        int start = 0;
        int link = 0;

        /*
         스타트 링크의 위치가 (1,1)과 같이 똑같은 인덱스값을 가지지 않으므로
             1 < i < N-1
             i+1 < j < N
         으로 설정하므로써 중복을 피함.
        */
        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                //i번째 사람과 j번째 사람이 true라면
                if(visit[i] && visit[j]){
                    start += iceRink[i][j]; //(i, j)의 값
                    start += iceRink[j][i]; //(j, i)의 값
                }
                else if(!visit[i] && !visit[j]){
                    link += iceRink[i][j]; //(i, j)의 값
                    link += iceRink[j][i]; //(j, i)의 값
                }
            }
        }

        //두 팀의 점수 차이(절댓값으로)
        int differentValue = Math.abs(start-link);

        //두팀의 점수 차이가 0인 경우는 가장 작은 최솟값이므로 더이상 탐색하지 않고 0으로 출력(프로그램 종료)
        if(differentValue == 0){
            System.out.println(differentValue);
            System.exit(0);
        }

        minValue = Math.min(differentValue, minValue);
    }

}