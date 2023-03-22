
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String[] b = new String[3];
        int[] c = new int[3];

        for (int i = 0; i < 3; i++) {
            b[i] = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (b[i].equals(a[j])) {
                    c[i] = j;
                }
            }
        }

        long sum = (c[0] * 10) + c[1];
        int n = c[2];
        for (int i = 1; i <= n; i++) {
            sum *= 10;
        }

        bw.write(String.valueOf(sum));
        bw.close();


    }
}
