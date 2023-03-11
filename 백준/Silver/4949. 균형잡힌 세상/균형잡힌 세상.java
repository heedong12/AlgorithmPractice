import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            int count=0;

            if (s.equals(".")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                //'(' 나 '[' 이면 push
                if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                }

                //')' 나 ']' 이고
                if (s.charAt(i) == ')' || s.charAt(i) == ']') {
                    //스택이 비어있다면 종료
                    if (stack.isEmpty()) {
                        count--;
                        break;
                    } else {  //스택이 비어있지 않다면
                        if (s.charAt(i) == ')') {
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                break;
                            }
                        } else if (s.charAt(i) == ']') {
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            if (stack.isEmpty()&& count==0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
