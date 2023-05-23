import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //상근이가 가지고 있는 숫자 카드 개수
        int[] have = new int[N];    //가지고 있는 숫자 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)     //가지고 있는 숫자 입력받고 저장
            have[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(have);  //오름차순 정렬
        
        int M = Integer.parseInt(br.readLine());    //구분해야 할 정수 개수
        st = new StringTokenizer(br.readLine());    
        int[] answer = new int[M];  //구분한 값 저장할 배열

        for (int i = 0; i < M; i++) {
            int start = 0, end = have.length - 1, mid = 0;
            int temp = Integer.parseInt(st.nextToken());    //temp에 구분해야 할 값 저장

            while (start <= end) {
                mid = (start + end) / 2;
                if (have[mid] == temp) {    //가지고 있는 숫자이면
                    answer[i]=1;    //answer에 1 저장
                    break;
                }
                //구분해야 할 숫자가 더 큰 경우에 start 값 오른쪽으로 옮김
                if(have[mid]<temp) start=mid+1;
                //구분해야 할 숫자가 작은 경우 end 값 왼쪽으로 옮김
                else end=mid-1; 
            }
        }
    
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(answer[i]==1) s.append("1 ");    //
            else s.append("0 ");
        }
        bw.write(String.valueOf(s));
        bw.close();

    }
}