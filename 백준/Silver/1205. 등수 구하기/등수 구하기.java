import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        //랭킹 리스트에 올라갈 점수들 넣을 배열
        List<Integer> list = new ArrayList<>();
        int rank = -2;


        //N이 0보다 큰 경우에만 둘째 줄 주어짐
        if (N > 0) {
            //둘째 줄 입력
            st = new StringTokenizer(br.readLine());
            //N개의 점수 랭킹 리스트에 저장
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        else{
            rank=0;
        }

        //리스트가 가득 차지 않았을때
        if (list.size() < P) {
            for (int i = 0; i < list.size(); i++) {
                //점수보다 작거나 같은 값의 인덱스 반환
                if (list.get(i) <= score) {
                    rank = i;
                    break;
                }
                //마지막 값보다 점수가 작을때
                if(i==list.size()-1){
                    if(list.get(i)>score){
                        rank=i+1;
                    }

                }
            }
        }
        //리스트가 가득 찼을 때
        else if(list.size()==P){
            for (int i = 0; i < P; i++) {
                //점수보다 작거나 같은 값의 인덱스 반환
                if (list.get(i) <= score) {
                    rank = i;
                    break;
                }
            }
            //리스트에 점수보다 작은 값이 없거나 마지막 값과 같을때
            if( rank==-2 || list.get(P-1)==score){
                rank=-2;
            }
        }

        bw.write(String.valueOf(rank + 1));
        bw.close();
    }
}
