import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s=br.readLine();
        int[] array=new int[26];

        for(int i=0;i<s.length();i++){
            //소문자
            if((int)s.charAt(i)>=97){
                array[(int)s.charAt(i)-97]++;
            }
            //대문자
            else{
                array[(int)s.charAt(i)-65]++;
            }
        }
        //A -> array[0]에 +1
        int max=0;  //제일 많이 나온 횟수
        int index=0;    //몇번째 값인지
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index=i;
            }
        }

        for(int i=0;i< array.length;i++){
            if(array[i]==max){
                count++;
            }
        }
        if(count==1){
            System.out.println((char)(index+65));
        }
        else{
            System.out.println("?");
        }

    }
}
