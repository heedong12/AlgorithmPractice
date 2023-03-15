import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M>=45){
            M-=45;
        }
        else {
            if(H==0){
                H=23;
                M+=15;
            }
            else{
                H-=1;
                M+=15;
            }
        }
        bw.write(String.valueOf(H) + " " + String.valueOf(M));
        bw.close();
    }
}
