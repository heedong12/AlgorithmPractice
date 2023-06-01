import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long GCD(long a, long b) {  //유클리드 호제법으로 최대공약수 구하기
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] num = new long[N];
        long[] den = new long[N];

        long temp1 = 0;     //분모의 답(최소공배수)
        long temp2 = 0;     //분자의 답

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            den[i] = Long.parseLong(st.nextToken());   //분자 저장
            num[i] = Long.parseLong(st.nextToken());   //분모 저장

            if(i==0) {
                temp1 = num[i];
                temp2 = den[i];
            }
            if (i >= 1) {
                //최소공배수(분모끼리 곱해서 최대공약수로 나눠줌)
                temp1 = (temp1 * num[i]) / GCD(temp1, num[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            den[i] = den[i] * (temp1 / num[i]);    //분모에 곱한 값만큼 분자에 곱해줌

            if (i >= 1) {
                temp2 = GCD(den[i - 1], den[i]);    //분자들의 최대공약수 구함
                den[i] = temp2;
            }
        }
        long gcd = GCD(temp1, temp2);

        bw.write(String.valueOf(temp2 / gcd + " " + temp1 / gcd));
        bw.close();

    }
}
    