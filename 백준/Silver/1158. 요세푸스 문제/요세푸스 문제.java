import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //문자열을 자르기 위해 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        //문자열을 붙이기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        //처음에 "<" 출력하기 위해
        sb.append('<');

        //StringTokenizer를 이용해서 입력받은 값을 순서대로 N과 K에 저장
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //큐 만듦
        Queue<Integer> queue = new LinkedList<>();

        //큐에 1~N까지 넣음
        for (int i = 1; i <= N; i++) queue.add(i);

        //큐에 하나 남기 전까지
        while (queue.size() != 1) {
            for (int i = 1; i < K; i++) {
                //1~(K-1)번째 값들을 지우고 뒤에 넣어줌
                queue.add(queue.remove());
            }
            //K번째 값을 지우고 sb에 붙여줌
            sb.append(queue.remove()).append(", ");
        }
        //마지막 남은 값을 넣고 ">" 붙여줌
        sb.append(queue.remove()).append('>');

        //값 출력
        bw.write(sb.toString());
        bw.close();
    }
}