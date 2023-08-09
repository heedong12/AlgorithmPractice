import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //인형 개수
        int K = Integer.parseInt(st.nextToken());   //라이언 인형 K개
        int[] arr = new int[N];
        ArrayList<Integer> lion = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   //인형 저장 -> 1이 라이언
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) lion.add(i);  //라이언 인덱스 저장
        }

        int start = 0, end = 0;
        int count = 0, temp = 0;
        int len = Integer.MAX_VALUE;

        if (lion.size() < K) {
            len = -1;
        } else {
            while (end < lion.size() - 1) {
                //if (lion.size() < K) break;    //라이언 인형이 K개 이하
                end = start + K-1;
                len = Math.min(len, lion.get(end) - lion.get(start)+1);
                start++;
            }
        }
        bw.write(String.valueOf(len));
        bw.close();
    }
}
