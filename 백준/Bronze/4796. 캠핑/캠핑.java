import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 1;  //출력 시 Case 번호를 부여하기 위해서 

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());    //L일만 사용 가능
            if (L==0){  //L>1이므로 0이면 종료를 뜻함
                break;
            }
            int P = Integer.parseInt(st.nextToken());    //연속하는 P일 중
            int V = Integer.parseInt(st.nextToken());    //V일 짜리 휴가

            int sum = (V / P) * L;  //V를 P로 나눈 몫과 사용가능한 L일 곱해서 sum에 넣어줌
            V -= P * (V / P);   //남은 휴가 날을 구함

            if (V >= L) {   //남은 휴가 날이 L일보다 크거나 같으면
                sum+=L;     //sum에 L 더해줌
            }else{      //남은 휴가 날이 P보다 작으면
                sum += V;   //sum에 남은 휴가날 더해줌
            }

            bw.write("Case " + String.valueOf(i) + ": " + String.valueOf(sum+"\n"));
            i++;

        }

        bw.close();
    }
}
