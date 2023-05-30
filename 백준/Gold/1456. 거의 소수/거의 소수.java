import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int b = (int)Math.sqrt(B);  //B의 제곱근
        int[] array = new int[b+1]; //초기값은 0으로 설정되어있음

        //소수 구하기
        for (int i = 2; i <= b; i++) {
            int j=2;
            while(true){
                if (i*j>b) break;
                array[i*j]=1;
                j++;
            }
        }

        int count=0;
        for (int i = 2; i <= array.length-1; i++) {
            long result=0;
            int j=2;
            if(array[i]==0){//소수이면
                while(true){
                    result =(long) Math.pow(i,j);
                    if(result>B) break;
                    if(result>=A) {
                        count++;
                    }
                    j++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
