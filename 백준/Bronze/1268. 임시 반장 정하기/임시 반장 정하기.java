import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N=학생 수
        int N = Integer.parseInt(st.nextToken());

        //학생들의 정보 저장(행-학생번호, 열-학년)
        int[][] info = new int[N][5];
        //같은 반이었던 학생 수 저장
        int[] sum = new int[N];

        //정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                info[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                for (int k=0;k<5;k++){  //학년
                    if(info[i][k]==info[j][k] && i!=j){
                        sum[i]+=1;
                        break;
                    }
                }
            }
        }

        int max=-1;
        int index=-1;
        for (int i = 0; i < N; i++) {
            if (max < sum[i]) {
                max = sum[i];
                index=i;
            }
        }
        bw.write(String.valueOf(index+1));
        bw.close();
    }
}
