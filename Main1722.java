import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1722 {
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        br.read();
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        int pNum = Integer.parseInt(st.nextToken());
        int[] match = new int[n];
        if (pNum == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= n; i++)
                arr[i - 1] = i;
            permutation1(arr, output, visited, 0, n, n, k);
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
                match[i] = Integer.parseInt(st.nextToken());
            }
            permutation2(arr, output, visited, 0, n, n, match);
        }


    }
    public static void permutation1(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, long k) {
        //종단조건
        //depth -> 내가 현재 고른 개수 (output의 인덱스)
        //r-> 내가 맨 처음에 고르기로 한 개수
        if (depth == r) {
            cnt++;
            if (cnt == k) {
                for (int i = 0; i < n; i++) {
                    System.out.print(output[i] + " ");
                }
                System.exit(0);
            }
            return;
        }
        //재귀함수 실행될 때마다 다시 0부터 시작해서 고를 수 있는지 없는지 확인한후에 줄세우기
        //visited[i]!=true이면 이 원소를 사용한적이 없다.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //i번째 원소를 줄을 세운 적이 없으니 줄 세워봄
                visited[i] = true;
                output[depth] = arr[i];
                //다음으로 가서 줄을 세울지 말지 결정하도록 재귀함수 호출
                permutation1(arr, output, visited, depth + 1, n, r, k);

                // i번 째 원소 줄에 세워놓고 경우의 수를 세었다.
                // i번째 원소를 사용 안 한 것으로 되돌려 놓고 다른 재귀함수 permutation에서 사용할 수 있도록 false로 바꿔줌
                visited[i] = false;
            }
        }
    }
    public static void permutation2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, int[] match) {
        //종단조건
        //depth -> 내가 현재 고른 개수 (output의 인덱스)
        //r-> 내가 맨 처음에 고르기로 한 개수
        if (depth == r) {
            cnt++;
            if (Arrays.equals(output, match)) {
                System.out.print(cnt);
                System.exit(0);
            }
            return;
        }

        //재귀함수 실행될 때마다 다시 0부터 시작해서 고를 수 있는지 없는지 확인한후에 줄세우기
        //visited[i]!=true이면 이 원소를 사용한적이 없다.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //i번째 원소를 줄을 세운 적이 없으니 줄 세워봄
                visited[i] = true;
                output[depth] = arr[i];
                //다음으로 가서 줄을 세울지 말지 결정하도록 재귀함수 호출
                permutation2(arr, output, visited, depth + 1, n, r, match);

                // i번 째 원소 줄에 세워놓고 경우의 수를 세었다.
                // i번째 원소를 사용 안 한 것으로 되돌려 놓고 다른 재귀함수 permutation에서 사용할 수 있도록 false로 바꿔줌
                visited[i] = false;
            }
        }
    }
}
