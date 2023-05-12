import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] N = br.readLine().toCharArray();
        String s = "";
        int sum=0;

        ArrayList<Integer> num = new ArrayList<>(); //숫자를 하나씩 잘라서 저장

        //N을 하나씩 잘라서 저장
        for (int i = 0; i < N.length; i++) {
            num.add(N[i] - '0');
        }

        Collections.sort(num);  //num 배열 오름차순으로 정렬

        if (num.contains(0)) {   //0이 없으면 30의 배수 만들 수 없음
            for (int i = num.size() - 1; i >= 0; i--) {   //가장 큰 수 만들어야되니까 큰 수를 앞에 저장
                s += num.get(i).toString();
                sum += num.get(i);
            }
        }else{
            sum=-1; //아래 조건 때문에 -1 저장
        }
        bw.write(sum % 3 == 0 ? s : "-1");
        bw.close();
    }
}
