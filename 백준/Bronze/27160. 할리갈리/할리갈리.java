import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //카드의 개수 N
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            //이미 있었던 과일
            if(map.containsKey(fruit)){
                //있었던 개수 + 입력받은 개수
                map.put(fruit, Integer.valueOf(st.nextToken())+map.get(fruit));
            }
            //새로운 과일
            else{
                map.put(fruit, Integer.valueOf(st.nextToken()));
            }
        }

        String answer = "NO";
        //5개인 과일이 있으면
        if(map.containsValue(5)){
            answer = "YES";
        }

        bw.write(answer);
        bw.close();
    }
}
