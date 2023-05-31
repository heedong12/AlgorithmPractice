import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] array = new int[B + 1];
        for (int i = 2; i <= B; i++) {   //array에 소수 저장
            if (array[i] == 1) continue;
            for (int j = 2 * i; j <= B; j += i) {
                array[j] = 1;
            }
        }

        int count = 0;
        for (int i = A; i <= B; i++) {
            int temp = 0;
            if (array[i] == 0) {
                temp = i;
                while (temp != 0) {
                    if (temp % 10 == D) {
                        count++;
                        break;
                    }
                    temp /= 10;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
