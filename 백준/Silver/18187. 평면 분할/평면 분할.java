import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //그릴 수 있는 직선의 개수
        int answer = 0;     //몇 개의 영역으로 분할할 수 있는지
        int count = 2;   //몇 개의 영역이 추가되는지

        for (int i = 1; i <= N; i++) {
            if (i <= 2) {
                answer+=count;
            }
            else if(i==3){
                answer+=++count;
            }else {
                answer += i % 3 != 0 ? count++ : count;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
