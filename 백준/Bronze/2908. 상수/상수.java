import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r=0; int r2=0;

        while(a!=0){
            r=r*10+(a%10);
            a/=10;
        }
        while(b!=0){
            r2=r2*10+(b%10);
            b/=10;
        }
        if(r>r2){
            bw.write(String.valueOf(r));
        }
        else{
            bw.write(String.valueOf(r2));
        }
        bw.close();
    }
}
