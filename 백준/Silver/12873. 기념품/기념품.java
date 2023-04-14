import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> list = new LinkedList<>();

        long t = 1;     //단계
        int num = 1;
        for (int i = 0; i < N; i++) {
            list.offer(i + 1);
        }

        //리스트에 값이 하나 남을때까지
        while (list.size() != 1) {
            //t단계 세제곱
            t = (long) num * num * num;

            //t단계를 list의 크기로 나누고 -1해서 인덱스 구함
            t = (t % list.size() )- 1;
            //인덱스 값은 음수일 수 없음
            if (t < 0) {
                t += list.size();
            }
            //t-1까지 빼서 다시 맨뒤로 넣어줌
            for (int i = 0; i < t; i++) {
                list.offer(list.poll());
            }
            //t번째 사람 제거
            list.poll();
            num++;
        }

        bw.write(String.valueOf(list.poll()));
        bw.close();
    }
}
