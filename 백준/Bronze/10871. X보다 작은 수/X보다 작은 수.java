import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int count=0;
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            int n= Integer.parseInt(st.nextToken());
            if(n<X){
                A[count]=n;
                count++;
            }
        }

        for(int i=0;i<count;i++){
            bw.write(String.valueOf(A[i]+" "));
        }
        bw.close();
    }
}
