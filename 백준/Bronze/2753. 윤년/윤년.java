import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());

        if(n%400==0){
            bw.write("1");
        }
        else if((n%4==0)&&(n%100!=0)){
            bw.write("1");
        }
        else{
            bw.write("0");
        }
        bw.close();
    }
}
