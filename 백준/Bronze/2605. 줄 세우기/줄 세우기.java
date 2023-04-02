import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList();
        //학생 수
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());;
        //번호 뽑는 순서대로 저장
        for (int i = 1; i <=N; i++) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num, i);
        }
        //list의 값들 뒤집어서 저장
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(String.valueOf(list.get(i)) + " ");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }
}
