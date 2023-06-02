import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long GCD(long a, long b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //정렬되기 바라는 행성의 개수
        long[] time = new long[N-2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long temp = 0;


        for (int i = 0; i < N - 2; i++) {
            time[i] = Long.parseLong(st.nextToken());     //행성 정렬 주기 저장

            if(i==0)temp = time[0];
            if(i>=1) {
                temp =(temp*time[i])/GCD(temp,time[i]);     //최소공배수 구함
            }
        }
        bw.write(String.valueOf(temp));
        bw.close();
    }
}
