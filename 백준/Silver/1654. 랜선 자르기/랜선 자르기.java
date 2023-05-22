import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   //이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());   //필요한 랜선의 개수
        long[] length = new long[K];
        long start=1;   //start 값 1로 초기화
        long mid=0;
        long end=0;
        //랜선의 길이 입력받음
        for (int i = 0; i < K; i++) {
            length[i] = Long.parseLong(br.readLine());
            if(length[i]>end) end = length[i];  //end에 가장 큰 값 저장
        }

        while(start<=end){
            mid = (start + end) / 2;    //중간 값 구함
            long count=0;
            for (int i = 0; i < K; i++) {
                count+=length[i]/mid;   //랜선의 개수
            }
            if(count>=N) start = mid+1;     //더 큰 값으로 잘라야 함
            else end=mid-1;     //더 작은 값으로 잘라야 함
        }

        bw.write(String.valueOf(end));
        bw.close();

    }
}
