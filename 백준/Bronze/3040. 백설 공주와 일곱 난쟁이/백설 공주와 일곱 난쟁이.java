import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자 담을 리스트
        List<Integer> list = new ArrayList<>();
        //9개의 숫자 담음
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int temp1 = 0;
        int temp2 = 0;

        //탈출반복문 지정
        loopOut:
        //처음부터 루프를 돔
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                //두 개의 숫자 삭제
                temp1 = list.remove(j);
                temp2 = list.remove(i);

                int sum = 0;

                // 리스트의 값들 모두 더함
                for (int a : list) {
                    sum += a;
                }
                // 리스트의 합이 100이면 출력
                if (sum == 100) {
                    for (int answer : list) {
                        bw.write(String.valueOf(answer)+"\n");
                    }
                    //이중 반복문 탈출
                    break loopOut;
                }
                // 합이 100이 아니라면 리스트에 다시 더해줌
                else {
                    list.add(i, temp2);
                    list.add(j, temp1);
                }
            }


        }
        bw.close();
    }
}
