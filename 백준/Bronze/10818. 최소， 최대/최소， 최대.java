import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int max=Integer.parseInt(st.nextToken());
        int min=max;

        for(int i=1;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            
            if(max<n){
                max=n;
            }
            if(min>n){
                min=n;
            }
        }
        bw.write(String.valueOf(min) + " " + String.valueOf(max));
        bw.close();

    }
}
