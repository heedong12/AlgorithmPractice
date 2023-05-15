import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        int count = 0;  //몇 번 감소시켜야 하는지

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());     //점수 입력 받고 저장
        }

        for (int i = N - 1; i > 0; i--) {
            if(score[i-1] >= score[i]){     //쉬운 레벨이 어려운 레벨보다 점수를 같거나 많이 받는 경우
                count+=score[i-1]-(score[i]-1);     //감소시켜야 하는 횟수를 count에 더해주고
                score[i-1]=score[i]-1;  //높은 레벨에서 -1 뺀 값을 낮은 레벨에 저장
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
