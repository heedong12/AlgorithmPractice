import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken());   //보도 못한 사람 수
        ArrayList<String> answer = new ArrayList<>();   //듣도 보도 못한 사람 저장할 배열
        HashMap<String, String> map = new HashMap<>();  //듣도 못한 사람 저장할 해시맵
        //듣도 못한 사람 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, s);
        }
        //듣도 못한 사람 중 보도 못한 사람 있으면 answer 배열에 저장
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                answer.add(s);
            }
        }
        //사전순으로 정렬
        Collections.sort(answer);
        //듣보잡의 수 출력
        bw.write(String.valueOf(answer.size())+"\n");
        //듣보잡 명단 출력
        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.close();
    }
}
