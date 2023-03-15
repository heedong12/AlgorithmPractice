import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());


        for(int i=0;i<N;i++){
            String s= br.readLine();
            int count=0;
            int sum=0;

            for(int j=0;j<s.length();j++) {
                if (s.charAt(j) == 'O') {
                    sum += 1;
                    if (j >= 1 && s.charAt(j - 1) == s.charAt(j)) {
                        count++;
                        sum += count;
                    }
                } else {
                    count = 0;
                }

            }
            bw.write(String.valueOf(sum+"\n"));
            bw.flush();

        }
        bw.close();
    }
}
