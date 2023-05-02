import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //거스름돈 액수
        int count = 0;  //5원 개수

        if (n % 5 == 0) {   //n이 5의 배수이면 5원으로만 거슬러줌
            count = n / 5;
        }
        else {
            // i에 n을 5로 나눈 값 저장 후, i에서 1씩 감소
            for (int i = n / 5; i >= 0; i--) {
                int temp = n - 5 * i;   //temp에 5의 배수 뺀 값 저장
                if (temp % 2 == 0) {    //temp가 2의 배수라면
                    //count에 5원의 개수인 i와 2원 개수인 (temp/2) 저장
                    count += i + (temp / 2);
                    break;
                }
            }
        }


        if (count == 0) {   //5원과 2원으로 거슬러 줄 수 없을 때
            bw.write("-1");
        } else {
            bw.write(String.valueOf(count));
        }

        bw.close();
    }
}
