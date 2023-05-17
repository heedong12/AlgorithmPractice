import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String color = br.readLine();

        int case1 = 1;
        int countB=0;
        int countR=0;
        int case2 = 1;
        if(color.charAt(0)=='B') countB++;
        else countR++;
        //순서대로 칠하는 경우
        for (int i = 1; i < N; i++) {
            if (color.charAt(i - 1) != color.charAt(i)) {
                case1++;
                if(color.charAt(i)=='B') countB++;
                else countR++;
            }
        }
        case2+=Math.min(countR,countB);
        bw.write(String.valueOf(Math.min(case1,case2)));
        bw.close();

    }
}
