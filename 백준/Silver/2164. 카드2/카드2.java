import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());    //1-N번의 카드
        //1~N까지 넣기
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        //큐에 값이 하나 남을때까지
        while (q.size() != 1) {
            q.poll();   //제일 위에 카드 버림
            int temp=q.poll();  //그 다음 카드 temp에 저장 후 버림
            q.offer(temp);  //맨 밑으로 저장
        }

        bw.write(String.valueOf(q.peek())); //큐에 남은 값은 하나
        bw.close();

    }
}
