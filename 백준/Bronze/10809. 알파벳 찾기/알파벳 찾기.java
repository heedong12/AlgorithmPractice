import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s=br.readLine();
        int[] array = new int[26];
        Arrays.fill(array,-1);

        for(int i=0;i<s.length();i++){
            if(array[(int)s.charAt(i)-97]==-1) {
                array[(int) s.charAt(i) - 97] = i;
            }
        }

        for(int i:array){
            bw.write(String.valueOf(i+" "));
        }
        bw.close();
    }
}
