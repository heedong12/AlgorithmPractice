import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //설탕 N킬로그램
        int N = Integer.parseInt(br.readLine());
        //들고가야 할 설탕 봉지 수 저장
        int count = 0;

        //N이 5의 배수
        if(N%5==0){
            count=N/5;
        }
        //N이 4이거나 7
        else if(N==4 || N==7){
            count=-1;
        }
        //N이 5의 배수 +1 이거나 5의 배수 +3
        else if(N%5==1||N%5==3){
            count=N/5+1;
        }
        //N이 5의 배수 +2 이거나 5의 배수 +4
        else if (N%5==2||N%5==4) {
            count=N/5+2;
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}

