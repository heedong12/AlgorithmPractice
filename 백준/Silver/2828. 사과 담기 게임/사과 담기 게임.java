import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //스크린 칸의 수
        int M = Integer.parseInt(st.nextToken());   //바구니의 크기
        int J = Integer.parseInt(br.readLine());    //사과의 개수

        //사과가 떨어지는 위치 담을 배열
        int[] location = new int[J];
        for (int i = 0; i < J; i++) {
            location[i] = Integer.parseInt(br.readLine()); //사과가 떨어지는 위치
        }

        //바구니(처음에는 가장 왼쪽에 위치)
        int bFront=1;
        int bBack=M;

        int count=0;    //바구니 이동 거리 저장

        //J만큼 반복
        for (int i = 0; i < J; i++) {
            //사과가 바구니보다 오른쪽에 있음
            if (location[i]>bBack){
                int a=location[i]-bBack;
                bBack+=a;
                bFront+=a;
                count+=a;
            }
            //사과가 바구니보다 왼쪽에 있음
            else if(location[i]<bFront){
                int a = bFront - location[i];
                bFront-=a;
                bBack-=a;
                count+=a;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
