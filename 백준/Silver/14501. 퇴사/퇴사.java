import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        //N+6인 이유 -> 걸리는 기간이 최대 5일임(index 편하게 보려고 +1까지)
        int[] period = new int[N+6];    //걸리는 기간
        int[] money = new int[N+6];     //받을 수 있는 금액
        int[] DP = new int[N+6];    //N+1일차에 돈을 받음

        //상담기간, 수익 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());   //상담기간 저장
            money[i] = Integer.parseInt(st.nextToken());    //수익 저장
        }

        int max=0;
        for(int i=1;i<=N+1;i++){    //1일부터 N일까지 전날 수익과 비교
            DP[i] = Math.max(max, DP[i]);   //현재 수익과 전날 수익 비교해서 큰 값 넣음
            //현재 수익과 받을 수익의 합과 저장되어 있는 값 비교해서 큰 값 넣음
            DP[i + period[i]] = Math.max(DP[i + period[i]], DP[i] + money[i]);
            //max에 최대 수익 저장
            max = Math.max(max, DP[i]);
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}
