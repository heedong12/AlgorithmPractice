import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //반복할 횟수
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<N;i++){
            //십진수 입력 받음
            int num=Integer.parseInt(br.readLine());
            //이진수 저장할 배열(반대로 저장)
            int[] array = new int[num];

            int index=0;

            while (num != 0 && num != 1) {
                array[index++] = num % 2;
                num/=2;
            }
            array[index]=num;

            for (int j=0;j<array.length;j++){
                if(array[j]==1){
                    sb.append(j+" ");
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
