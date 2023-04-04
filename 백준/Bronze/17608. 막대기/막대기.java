import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] stick = new int[N];   //막대기 순서대로 저장

        for (int i = 0; i < N; i++) {
          stick[i]=Integer.parseInt(br.readLine());
        }

        int count=1;
        int max=stick[N-1];
        for (int i = N - 2; i >= 0; i--) {
            if(max<stick[i]){
                count++;
                max = stick[i];
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
