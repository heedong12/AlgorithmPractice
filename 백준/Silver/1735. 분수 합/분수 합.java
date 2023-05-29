import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int c1 = (a1 * b2) + (b1 * a2);
        int c2 = a2 * b2;

        for (int i=c1;i>1;i--){
            if (c1 % i == 0 && c2 % i == 0) {
                c1/=i;
                c2/=i;
            }
        }

        bw.write(String.valueOf(c1 + " " + c2));
        bw.close();
    }
}
