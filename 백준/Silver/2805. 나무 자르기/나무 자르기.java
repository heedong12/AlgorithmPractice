import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //나무의 수
        int M = Integer.parseInt(st.nextToken());   //가져가려는 나무의 길이

        long[] tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());     //나무 길이 저장
        }

        Arrays.sort(tree);
        long start = 0, mid = 0, end = tree[N - 1];  //end에 가장 큰 나무 길이 저장

        while (start <= end) {
            long sum = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid)
                    sum += tree[i] - mid;   //나무 길이가 mid보다 크면 자름
            }

            if(sum<M) end=mid-1; //나무를 더 많이 잘라야하니까 길이 줄임
            else start=mid+1;   //나무를 더 조금 잘라야하니까 길이 늘림

        }
        bw.write(String.valueOf(end));
        bw.close();
    }
}
