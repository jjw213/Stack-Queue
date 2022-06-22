import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        br.read();
        Stack<String> stack2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
//            System.out.println("???str="+str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
//                    System.out.println("str=" + str.charAt(j));
                    stack.push("a");
                } else if (str.charAt(j) == ')') {
//                    System.out.println("pop!!");
                    if (!stack.isEmpty())
                        stack.pop();
                    else {
                        System.out.println("NO");
                        break;
                    }
                }
                if (j + 1 == str.length()) {
                    if (stack.isEmpty()) System.out.println("YES");
                    else System.out.println("NO");
                    break;
                }
            }
        }
    }
}
