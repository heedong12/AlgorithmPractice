
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());   //지구
        int S = Integer.parseInt(st.nextToken());   //태양    
        int M = Integer.parseInt(st.nextToken());   //달

        //가장 작은 범위인 E를 기준으로 잡음
        int count = E;  //몇년인지 출력하기 위해서 (초기값 : E)
        int tempS = E;  //S와 비교하기 위해
        int tempM = E;  //M와 비교하기 위해

        if (S == E && S == M) {     //15년이하일때
            bw.write(String.valueOf(count));
        } else {
            while (S != tempS || M != tempM) {  //tempS==S 이고 tempM==M이 될 때까지
                tempS = (tempS + 15) % 28;  //tempS에 15씩 S의 범위인 28로 나눔
                if (tempS == 0) {   //tempS가 28의 배수일 때는 28 저장
                    tempS = 28;
                }
                tempM = (tempM + 15) % 19;  //tempM에 15 더하고 M의 범위인 19로 나눔 
                if (tempM == 0) {   //tempM이 19의 배수일 때는 19 저장
                    tempM = 19;
                }
                count += 15;    //count값 15씩 증가 
            }
            bw.write(String.valueOf(count));
        }
        bw.close();
    }
}
