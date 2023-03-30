import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //단어의 수
        HashMap<String, Integer> word = new HashMap<>();    //해시맵에 단어 저장
        StringBuffer sb;    //단어를 뒤집기 위해서 StringBuffer 사용
        String answer = ""; //정답 저장

        for (int i = 0; i < N; i++) {
            String s = br.readLine();   //입력받은 문자
            sb = new StringBuffer(s);
            sb = sb.reverse();  //뒤집은 문자

            //단어를 뒤집은 다음 일치하는 값이 있으면 answer에 저장
            if (word.containsKey(sb.toString())) {
                answer = s;
                word.put(s, s.length());
            }
            //입력받은 단어가 뒤집어도 같은 단어이면 answer에 저장
            else if (sb.toString().equals(s)) {
                answer = s;
                word.put(s, s.length());
            }
            //위에 해당되지 않음
            else {
                word.put(s, s.length());
            }
        }

        int center = answer.length() / 2;

        bw.write(String.valueOf(word.get(answer)) + " " + answer.charAt(center));
        bw.close();

    }
}
