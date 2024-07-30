import java.util.*;
import java.io.*;

/**
 * 1. 입력
 *  1-1. n개의 정보 입력
 *  1-2. 1인 경우 : a 번호인 학생 1명이 맨 뒤에 줄서기
 *  1-3. 2인 경우 : 맨 앞에 대기중인 학생이 줄어듬
 *
 * 2. 로직
 *  2-1. 1 a : a 값을 deque에 담는다.
 *  2-2  2 : deque에서 Poll하여 가장 앞에값을 뺀다.
 *  2-3  위의 과정을 반복하면서 deque 크기가 Max보다 클 경우 max를 deque 크기로 초기화
 *  2-4  2-3 경우 일 때 deque 가장 뒷번호를 우선수위큐에 저장 (오름차순)
 *  2-5  최대인 경우가 여러번이라면 모두 가장 뒷번호를 우선순위큐에 담고 마지막에 우선순위큐에서 값을 출력
 *
 * 3. 출력
 *  3-1. 대기 학생수 최대일 때 학생 수
 *  3-2. 최대 학생 수일 때 대기중인 항색의 번호
 *  3-3. 최대 학생 수가 여러번인 경우 가장 뒤에 있는 학생 번호가 가장 작은 경우
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<LineInfo> pq = new PriorityQueue<>();
    static Deque<Integer> deque = new LinkedList<>();
    static StringTokenizer st;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{

        int N = Integer.parseInt(br.readLine());

        // 로직 수행
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String typeNum = st.nextToken();

            if (Integer.parseInt(typeNum) == 1) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            if (Integer.parseInt(typeNum) == 2) {
                deque.removeFirst();
            }
            if (max <= deque.size()) {
                max = deque.size();
                pq.add(new LineInfo(max, deque.peekLast()));
            }
        }

        LineInfo poll = pq.poll();
        System.out.println(poll.max + " " + poll.studentNum);
    }
    static class LineInfo implements Comparable<LineInfo>{
        int max, studentNum;

        public LineInfo(int max, int studentNum){
            this.max = max;
            this.studentNum = studentNum;
        }

        @Override
        public int compareTo(LineInfo b){
            if(this.max == b.max){
                return this.studentNum - b.studentNum;
            }else{
                return b.max - this.max;
            }
        }
    }
}
