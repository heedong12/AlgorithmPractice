import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫째줄 N과 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> q = new ArrayList<>();
        //1~N까지 저장
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        //둘째줄 뽑아야 하는 수 입력
        st = new StringTokenizer(br.readLine());
        int count=0;    //연산 횟수 저장할 변수
        for (int i=0;i<M;i++){
            int temp = Integer.parseInt(st.nextToken());

            //앞에 있는 수가 더 많을때
           if (q.indexOf(temp)>q.size()-q.indexOf(temp)){
               while (q.get(0)!=temp){
                   //제일 마지막 값을 앞으로 옮김
                   q.add(0,q.remove(q.size()-1));
                   count++;
               }
               q.remove(0);
           }
           //뒤에 있는 수가 더 많거나 같을 때
           else {
               while(q.get(0)!=temp){
                   q.add(q.remove(0));
                   count++;
               }
               q.remove(0);
           }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
