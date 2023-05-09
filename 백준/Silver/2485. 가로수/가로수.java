import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //유클리드 호제법을 이용해서 최대공약수 구하기
    private static int GCD(int a, int b){   //a가 큰 숫자
        if (b==0){  //나머지가 0이면 a 리턴해줌
            return a;
        }
        else {  //나머지가 0이 될 때까지 나눔
            return GCD(b, a % b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> tree = new ArrayList<>();    //나무 위치 저장
        int[] gap = new int[N-1]; //나무 간격 저장

        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(br.readLine()));

            if (i > 0) {
                gap[i - 1] = tree.get(i) - tree.get(i - 1); //나무 사이 간격 구함
            }
        }

        for (int i = 0; i < N - 2; i++) {
            //첫 번째 인자로 큰 숫자, 두 번째 인자로 작은 숫자
            gap[i + 1] = GCD(Math.max(gap[i], gap[i + 1]), Math.min(gap[i], gap[i + 1]));
        }

        int treeGap = gap[gap.length - 1];  //나무 간격

        //첫 번째 나무와 마지막 나무 간격에서 구한 나무 간격으로 나누고, N-1을 빼주면 심어야 할 나무의 값
        bw.write(String.valueOf((tree.get(N - 1) - tree.get(0)) / treeGap - (N - 1)));
        bw.close();

    }
}
