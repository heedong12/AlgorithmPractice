
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] input = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'X') {
                    input[i][j] = 1;
                }
            }
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] == 1) {
                    break;
                }
                if (j==M-1){
                    count1++;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (input[i][j] == 1) {
                    break;
                }
                if (i==N-1){
                    count2++;
                }
            }
        }

        bw.write(String.valueOf((count1>count2)?count1:count2));
        bw.close();

    }
}
