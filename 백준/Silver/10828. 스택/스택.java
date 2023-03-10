import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] stack;
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        //스택 구현할 배열
        stack = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    int n=Integer.parseInt(st.nextToken());
                    push(n);
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }

    }

    static void push(int n){
        stack[index] = n;
        index++;
    }

    static void pop() {
        if (index == 0) {
            System.out.println("-1");
        } else {
            System.out.println(stack[index-1]);
            index--;
        }
    }

    static void size () {
        System.out.println(index);
    }


    static void empty () {

        if (index == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void top () {
        if (index == 0) {
            System.out.println("-1");
        } else {
            System.out.println(stack[index-1]);
        }
    }

}
