import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //N과 M 입력받고 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //교과서 수
        int M = Integer.parseInt(st.nextToken());   //더미 수
        String answer = "Yes";

        int[] array;
        
        for (int i=0;i<M;i++) {
            int bookNumber = Integer.parseInt(br.readLine());   //쌓인 교과서의 수
            array = new int[bookNumber];
            //교과서가 쌓여있는 번호 순서대로 주어짐
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bookNumber; j++) {
                array[j] = Integer.parseInt(st.nextToken());
                //전에 저장되었던 값이 현재 값보다 작을 수 없음
                if (j!=0){
                    if (array[j-1]<array[j]){
                        answer = "No";
                        break;
                    }
                }
            }
        }
        bw.write(answer);
        bw.close();
    }
}
