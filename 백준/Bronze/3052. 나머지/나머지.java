import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<10;i++){
            int n=(Integer.parseInt(br.readLine()))%42;

            if(!a.contains(n)){
                a.add(n);
            }
        }

        bw.write(String.valueOf(a.size()));
        bw.close();
    }
}
