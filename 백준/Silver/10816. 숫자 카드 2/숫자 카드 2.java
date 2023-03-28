import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //상근이가 가지고 있는 숫자 카드의 개수
        int N = Integer.parseInt(br.readLine());
        //정수 저장할 해시맵(key=정수, value=개수)
        HashMap<Integer, Integer> map = new HashMap<>();
        //숫자 카드에 적혀 있는 정수들 저장
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            //맵에 있으면 개수 가져와서 1 더한 후 다시 넣음
            if(map.containsKey(number)){
                int count = map.get(number);
                map.put(number, count + 1);
            }
            else{
                //맵에 없으면 추가
                map.put(number,1);
            }
        }

        //숫자 카드 개수 주어짐
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        //상근이가 몇 개 가지고 있는지 저장할 배열
        int[] count = new int[M];
        //상근이가 몇 개 가지고 있는지 확인
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (map.containsKey(number)) {
                count[i] = map.get(number);
            }
            else {
                count[i]=0;
            }
            bw.write(String.valueOf(count[i]+" "));
        }
        bw.close();
    }
}
