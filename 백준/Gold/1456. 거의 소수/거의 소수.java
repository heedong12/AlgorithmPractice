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
            while(array[i]==0){
                if (i*j>b) break;   //B의 제곱근보다 크면 while문 종료
                array[i*j]=1;   //i의 배수들을 1로 설정
                j++;
            }
        }

        int count=0;    //거의 소수
        for (int i = 2; i <= array.length-1; i++) {
            long result=0;
            int j=2;
            if(array[i]==0){    //소수이면
                while(true){
                    result =(long) Math.pow(i,j);   //소수의 2제곱, 3제곱 ..
                    if(result>B) break;     //소수의 N제곱이 B보다 크면 종료
                    if(result>=A) {     //소수의 N제곱이 A보다 크면 count +1
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
