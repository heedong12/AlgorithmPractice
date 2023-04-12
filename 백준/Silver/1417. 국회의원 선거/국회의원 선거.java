
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //국회의원 후보수
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];   //다른 사람의 득표 수 저장
        int count = 0;    //매수할 사람 수
        int number = 0;     //다솜이 득표 수 저장

        //배열에 저장
        for (int i = 0; i < N; i++) {
            if (i == 0) {   //첫번째 값은 다솜이의 득표 수
                number = Integer.parseInt(br.readLine());
            } else {    //나머지는 다른사람의 득표 수
                array[i] = Integer.parseInt(br.readLine());
            }
        }

        while (true) {
            Arrays.sort(array);     //오름차순 정렬

            //배열의 가장 큰 값이 다솜이 득표수보다 크거나 같으면
            if(number<=array[array.length-1]){                      
                array[array.length-1]--;    //오름차순된 배열의 마지막 값에 -1  
                number++;   //다솜이 득표 수 +1
                count++;    //매수할 사람 +1
            }
            //다솜이 득표 수가 가장 많으면 종료
            else{    
                break;
            }

        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
