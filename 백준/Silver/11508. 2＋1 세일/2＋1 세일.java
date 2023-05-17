import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] price = new Integer[N];

        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }
        int minP = 0;     //최소비용
        Arrays.sort(price, Collections.reverseOrder());     //내림차순 정렬

        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 || i % 3 == 1) minP += price[i];
        }

//        if (N % 3 == 1) {
//            minP += price[N - 1];
//        } else if (N % 3 == 2) {
//            minP += price[N - 2];
//        }

        bw.write(String.valueOf(minP));
        bw.close();
    }
}
