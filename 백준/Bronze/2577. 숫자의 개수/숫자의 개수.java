import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array=new int[10];

        int result=1;
        for(int i=0;i<3;i++){
            int n=Integer.parseInt(br.readLine());
            result*=n;
        }



        while(result!=0){
            array[(result%10)]++;
            result/=10;
        }

        for(int i=0;i<10;i++){
            bw.write(String.valueOf(array[i])+"\n");
        }

        bw.close();
    }
}
