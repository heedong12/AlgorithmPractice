import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[8];

        for(int i=0;i<=7;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        String s="";

        for(int i=1;i<=7;i++){
            if(array[i-1]+1==array[i]){
                s="ascending";
            }
            else if(array[i-1]-1==array[i]){
                s="descending";
            }
            else{
                s = "mixed";
                break;
            }
        }
        bw.write(s);
        bw.close();
    }
}
