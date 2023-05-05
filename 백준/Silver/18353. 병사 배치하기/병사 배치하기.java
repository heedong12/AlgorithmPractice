import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solider = new int[N];
        int[] DP = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            solider[i] = Integer.parseInt(st.nextToken());  //병사 전투력 거꾸로 저장
            DP[i] = 1;  //1로 초기화
        }

        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //i에 대해 i보다 작은 인덱스의 값들 모두 비교
                //i의 전투력보다 작은 전투력 발견 시
                if (solider[j] < solider[i]) {
                    //최장 증가 부분 수열 구함
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            max = Math.max(max, DP[i]); //DP[]에서 최대값 구하기
        }
        bw.write(String.valueOf(N - max));  //열외해야하는 병사 수
        bw.close();
    }
}
