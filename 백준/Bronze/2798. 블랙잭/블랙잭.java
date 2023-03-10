import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int index=0;
        while (st.hasMoreTokens()){
            array[index]=Integer.parseInt(st.nextToken());
            index++;
        }

        int result=0;
        int max=0;


        for(int i=0;i<N-2;i++){
            for (int j=i+1;j<N-1;j++){
                for (int k=j+1;k<N;k++){
                    result=array[i]+array[j]+array[k];

                    if(result<=M && max<=result){
                        max=result;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
