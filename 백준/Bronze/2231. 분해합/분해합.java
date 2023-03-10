import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a=0;
        int b=0;
        int index2=0;
        int[] array = new int[N];
        int[] result=new int[N];

        for (int i=1;i<N;i++){
            int index=0;
            b=i;

            do {
                a = b % 10;
                b = b / 10;
                array[index++]=a;

            } while(b!=0);

            int sum=0;
            for (int j=0;j<index;j++){
                sum+=array[j];
            }

            if(sum+i==N){
                result[index2++]=i;
            }

        }

        int min=N;
        for(int i=0;i<index2;i++){
            if(result[i]<min){
                min=result[i];
            }
        }
        if(index2==0){
            System.out.println("0");
        }
        else {
            System.out.println(min);
        }
    }
}
