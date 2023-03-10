import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] q;
    public static int count = 0;
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        q = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    push(n);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
    }

    static void push(int n) {
        q[index + count] = n;
        count++;
    }

    static void pop() {
        if (count == 0) {
            System.out.println("-1");
        } else {
            count--;
            System.out.println(q[index++]);
        }
    }

    static void size() {
        System.out.println(count);
    }

    static void empty() {
        if (count!=0){
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }

    static void front() {
        if(count==0){
            System.out.println("-1");
        }
        else {
            System.out.println(q[index]);
        }
    }

    static void back() {
        if(count==0){
            System.out.println("-1");
        }
        else {
            System.out.println(q[index + count - 1]);
        }
    }
}
