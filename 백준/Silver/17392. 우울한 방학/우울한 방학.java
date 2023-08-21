import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //인호의 약속 개수
        int M = Integer.parseInt(st.nextToken());   //방학 일수

        int[] arr = new int[N];
        int sumH =0;    //기대행복 값들의 합
        st = new StringTokenizer(br.readLine());
        //약속의 기대행복 값들의 합
        for (int i = 0; i < N; i++) {
            sumH += Integer.parseInt(st.nextToken());

        }

        int sum = 0;
        int minusDay = M-(sumH+N);
        if(minusDay<=N+1 && minusDay>0){
            sum = minusDay;
        }else if(minusDay>N+1){
            int temp = 1;
            while(true){
                for (int i = 1; i <= N + 1; i++) {
                    sum += Math.pow(temp, 2);
                    minusDay--;
                    if(minusDay==0) break;
                }
                if(minusDay==0) break;
                temp++;
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
