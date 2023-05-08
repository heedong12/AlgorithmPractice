import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //N개의 창문, N명의 사람
        int count=1;    //열린 창문 수

        while(count*count<=N){  //count 제곱이 N보다 작거나 같을때까지
            count++;    //count + 1
        }
        
        bw.write(String.valueOf(count-1));  //마지막 카운트는 제외
        bw.close();
    }
}
