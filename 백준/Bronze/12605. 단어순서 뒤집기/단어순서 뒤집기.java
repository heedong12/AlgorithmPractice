import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 케이스 개수
        int N = Integer.parseInt(br.readLine());
        //N번 반복
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //단어 저장할 리스트 생성
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());   //단어 저장
            }
            bw.write("Case #"+String.valueOf(i+1)+": ");
            //저장된 단어 순서 뒤집어서 출력
            for (int j=list.size()-1;j>=0;j--){
                bw.write(list.get(j)+" ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
