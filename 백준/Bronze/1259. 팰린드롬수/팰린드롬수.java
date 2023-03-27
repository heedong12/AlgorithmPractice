import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        while (!(s = br.readLine()).equals("0")) {
            String answer = "yes";

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                    answer = "yes";
                } else {
                    answer = "no";
                    break;
                }
            }
            bw.write(answer+"\n");
            bw.flush();
        }
        bw.close();
    }
}

