import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());

        //첫번째 자리에 올 수 있는 수들 = 소수
        ArrayList<Integer> arr= new ArrayList<>();
        //나머지 자리에 올 수 있는 수들 = 5를 제외한 홀수
        int arr2[]={1,3,7,9};
        ArrayList<Integer> answer=new ArrayList<>(Arrays.asList(2,3,5,7));

        int len=1;
        while(N>len){
            arr.addAll(answer);
            answer.clear();

            for(int i=0;i<arr.size();i++){
                int temp=arr.get(i);
                for(int j=0;j<4;j++){
                    if(IsPrime(temp*10+arr2[j])){
                        answer.add(temp*10+arr2[j]);
                    }
                }
            }
            arr.clear();
            len++;
        }

        Iterator iter = answer.iterator();
        while(iter.hasNext()){
            bw.write(String.valueOf(iter.next()+"\n"));
        }
        bw.close();
    }
    static boolean IsPrime(int number){
        for(int i=2;i*i<number;i++){
            if(number%i==0) return false;
        }
        return true;
    }

}
