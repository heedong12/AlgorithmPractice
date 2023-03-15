import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max=0;
        int count=0;
        for(int i=0;i<9;i++){
            int N=Integer.parseInt(br.readLine());
            if(N>max){
                max=N;
                count=i+1;
            }
        }
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(count));
        bw.close();
    }
}
