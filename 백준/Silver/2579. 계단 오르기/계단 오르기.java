import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //배열 크기가 N+3인 이유 => DP[3]까지 설정해주기 때문에 ArrayIndexOutOfBounds 발생하지 않도록
        int[] DP = new int[N + 3];   //최대값 구하기 위해
        int[] score = new int[N + 3];

        for (int i = 1; i <= N; i++) {   //점수 입력받고 저장
            score[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = score[1];   //첫번째 계단까지 가는 방법
        DP[2] = score[2] + score[1];   //두번째 계단까지 가는 방법(최대값이므로 1->2)
        //세번째 계단까지 가는 방법(1->3 이거나 2->3)
        DP[3] = Math.max(score[1],score[2])+score[3];

        //4번째부터 반복문 돌림
        //4번째 계단까지 가는 방법(1->3->4 이거나 1->2->4)
        //1->3->4 DP[1]+score[3]
        //DP[3]이 안되는 이유 = 2번째 계단을 건너뛰었기 때문에
        //1->2->4 DP[2]
        //두가지 경우를 비교 후 더 큰 값과 현재 계단의 값 더함
        for (int i = 4; i <=N ; i++) {
            DP[i] = Math.max(score[i - 1] + DP[i - 3], DP[i - 2]) + score[i];
        }

        bw.write(String.valueOf(DP[N]));
        bw.close();
    }
}
