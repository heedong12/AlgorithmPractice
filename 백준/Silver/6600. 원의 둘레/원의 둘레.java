import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer("");

        double arr[] = new double[6];   //세 점 저장
        String input = "";

        while ((input=br.readLine())!=null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            for (int i = 0; i < 6; i++) {
                arr[i] = Double.parseDouble(st.nextToken());
            }

            double d1 = distance(arr[2], arr[0], arr[3], arr[1]);
            double d2 = distance(arr[4], arr[2], arr[5], arr[3]);
            double d3 = distance(arr[4], arr[0], arr[5], arr[1]);

            double s = (d1 + d2 + d3) / 2;
            double A = Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
            double R = (d1 * d2 * d3) / (4 * A);
            double C = 2 * Math.PI * R;
            C = Math.round(C * 100) / 100.0;

            bw.write(String.valueOf(C + "\n"));
        }

        bw.close();

    }

    static double distance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
