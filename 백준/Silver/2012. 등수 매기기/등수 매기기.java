import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] grade = new int[N];
        long sum=0;  //불만도의 합

        for (int i = 0; i < N; i++) {
            grade[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(grade); //오름차순으로 정렬
        for (int i = 0; i < N; i++) {
            if(grade[i]>i+1){   //인덱스+1이 등수이므로 비교해서 절대값 구함
                sum+=grade[i]-i-1;
            }else{
                sum+=i+1-grade[i];
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
