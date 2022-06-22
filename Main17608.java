import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        br.read();
        int cnt = 1;
//        int[] arr =new int[n];
//        for(int i=0;i<n;i++){
//            st=new StringTokenizer(br.readLine());
//            arr[i]=Integer.parseInt(st.nextToken());
////            br.read();
//        }
//        int best=arr[n-1];
//        for(int i=n-2;i>=0;i--)
//        {
//            if(best<arr[i]){
//                cnt++;
//                best=arr[i];
//            }
//        }
        Stack<Integer> stack = new Stack<Integer>();
        int best=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int item =Integer.parseInt(st.nextToken());
            stack.push(item);
            if(i==n-1) best =item;

//            br.read();
        }
        for(int i=n;i>0;i--){
            int a = stack.pop();
            if(best<a){
                cnt++;
                best=a;
            }
        }
        System.out.println(cnt);
    }
}
