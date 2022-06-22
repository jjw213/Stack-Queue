import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2164 {
    public static void main(String[] args) {
//큐를 이용해서 데이터의 순서를 지정하는 문제
//큐를 사용해서 데이터를 추가하고, 데이터를 삭제를 할 수 있는지 물어보는 문제

//n=4
//1 2 3 4
//아래와 같은 동작을 반복한다.

//제일 위에 있는 카드를 바닥에 버린다.
//2 3 4
//제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
// 3 4 2

// ..

        Scanner sc = new Scanner(System.in);

//카드가 몇 장 있는지를 입력 받는다.
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();

//카드에 번호를 매긴다. ==> 큐에 번호 순서대로 저장한다.
//카드는 1번부터 시작해서 n번까지 있다.
        for(int i=1; i<=n; i++){
//offer는 삽입 실패시 false 리턴/ 성공시 true 리턴
//add는 삽입 실패시 예외를 발생
            queue.offer(i);
//queue.add(i);

        }

//두가지 동작을 반복
//맨 위에 있는 카드를 버린다.
//맨 위에 있는 카드를 맨 아래로 옮긴다.
//이 동작을 언제까지? ==> 카드가 한 장 남을 때까지
//카드를 큐에 저장 : 카드 갯수는 size()
//반복문을 사용한다. ==> 언제까지 반복하면 될까요?
//size() > 1
        while(queue.size() > 1) {
//맨 위의 카드를 버린다. ==> 원소를 하나 꺼낸다.
            queue.poll();
//queue.remove();
        int next = queue.poll();
        queue.offer(next);
        }
        System.out.println(queue.poll());
    }
}
