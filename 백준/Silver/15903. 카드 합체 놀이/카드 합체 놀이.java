import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //카드의 개수
        int m = Integer.parseInt(st.nextToken());   //카드 합체 몇 번 하는지

        st = new StringTokenizer(br.readLine());    //처음 카드의 상태
        long[] card=new long[n];

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        while(m>0){
            Arrays.sort(card);  //카드 오름차순 정렬
            long temp=card[0]+card[1];   //가장 작은 값 두개 더하고
            card[0]=temp; card[1]=temp;     //덮어씀
            m--;
        }
        long sum=0;
        for (int i = 0; i < n; i++) {
            sum += card[i];
        }
        
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
