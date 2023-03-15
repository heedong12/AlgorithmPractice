import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum=0;
        for (int i=0;i<5;i++){
            int a=Integer.parseInt(st.nextToken());
            a=a*a;
            sum+=a;
        }
        sum=sum%10;
        bw.write(String.valueOf(sum));
        bw.close();

    }
}
