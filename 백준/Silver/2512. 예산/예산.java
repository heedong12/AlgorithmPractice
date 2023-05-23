import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //지방의 수
        int[] cost = new int[N];
        int start=1,mid=0,end=0;
        long sum=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i]; //예산요청의 총 합
            if (cost[i] > end) {
                end = cost[i];  //가장 큰 값 end에 저장
            }
        }

        long M = Long.parseLong(br.readLine());   //총 예산
        if(M>=sum){     //총 예산보다 예산요청이 작거나 같으면 end 출력
            bw.write(String.valueOf(end));
        }
        else{   //총 예산보다 예산요청이 크면
            while(start<=end) {
                mid = (start + end) / 2;
                long temp=0;

                for (int i = 0; i < N; i++) {
                    if(mid>cost[i]) temp+=cost[i];
                    else temp+=mid;
                }
                if (temp <= M) {  //현재 필요한 예산이 총 예산보다 작거나 같으면
                    start = mid + 1;    //예산 늘림
                } else {    //현재 필요한 예산이 총 예산보다 많으면
                    end = mid - 1;  //예산 줄임
                }
            }
            bw.write(String.valueOf(end));
        }
        bw.close();
    }
}
