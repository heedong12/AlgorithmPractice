import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //전체 용액의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] sol = new long[N];   //용액의 특성 값 저장

        for (int i = 0; i < N; i++) {
            sol[i] = Long.parseLong(st.nextToken());
        }

        long sol1 = 0, sol2 = 0;     //정답 출력을 위해
        int start = 0, end = N - 1;     //인덱스 저장
        long min = Long.MAX_VALUE;

        while (start < end) {
            long sum = sol[start]+sol[end];  //절대값을 이용해서 차이 구함

            if(Math.abs(sum)<min){    //min보다 작은 차이가 나오면
                min=Math.abs(sum);    //min에 저장
                sol1=sol[start];    //정답 출력을 위해 저장
                sol2=sol[end];      //정답 출력을 위해 저장
            }
            if(sum<=0) start++;     //차이가 0보다 작거나 같으면 왼쪽 인덱스 증가
            else end--;     //차이가 0보다 크면 오른쪽 인덱스 감소
        }

        bw.write(String.valueOf(sol1 + " " + sol2));
        bw.close();

    }
}
