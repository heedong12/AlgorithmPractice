import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    //Test case의 수

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k + 1][n];
            //0층 -> 1호 1명, 2호 2명 ...
            for (int j = 0; j < n; j++) {
                apt[0][j] = j+1;
            }
            //입력받은 값까지 각 층의 호에 사람들 넣기
            for (int a = 1; a <= k; a++) { //층
                for (int b = 0; b < n; b++) {  //호
                    //1호에 사는 사람들은 층에 관계없이 1명
                    if (b == 0) {
                        apt[a][b] = 1;
                    } else {
                        apt[a][b] = apt[a][b - 1] + apt[a - 1][b];
                    }
                }
            }
            //나의 아래층 1호부터 내가 사는 호까지
            int sum=0;
            for(int a=0;a<n;a++){
                sum+=apt[k-1][a];
            }

            bw.write(String.valueOf(sum)+"\n");
        }
        bw.close();
    }
}
