import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] array = s.split("");
            int count=0;

            for (int j = 0; j < array.length; j++) {
                if(count>=0){
                    if(array[j].equals("(")){
                        count+=1;
                    }
                    else if(array[j].equals(")"))
                        count-=1;
                    }
                else{
                    break;
                }

            }
            if(count==0){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
