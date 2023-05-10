import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());    //먹어야 하는 초콜릿 개수
        double choco=0; //구매해야할 가장 작은 초콜릿의 크기
        int count=0;    //몇 번 쪼개야 하는지

        //구매해야하는 가장 작은 초콜릿의 크기 구하기
        for (int i = 0; ; i++) {
            if((choco = Math.pow(2, i))>=K){
                break;
            }
        }
        int choco2 = (int) choco;
        while(K>0){
            if (K < choco2) {   //먹어야하는 초콜릿 개수 보다 초콜릿이 더 크면
                choco2 /= 2;    //두 조각으로 쪼개고
                count++;    //count +1
            }
            else K-=choco2;     //아니면 초콜릿 먹음
        }
        bw.write(String.valueOf((int)choco+" "+count));
        bw.close();
    }
}
