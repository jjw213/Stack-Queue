import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main10845 {
    public static void main(String[] args) {
        Queue<String> queue =new Queue<>();
        StringBuilder sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            String cmd = sc.next();
            switch (cmd){
                case "push":
                    int a= sc.nextInt();
                    queue.push(String.valueOf(a));
                    break;
                case "pop":
                    String item = queue.pop();
                    if(item==null) {
                        sb.append(-1+"\n");
                        break;
                    }
                    sb.append(item+"\n");
//                    System.out.println(item);
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
//                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty())
//                        System.out.println(1);
                        sb.append(1+"\n");
//                    else System.out.println(0);
                    else sb.append(0+"\n");
                    break;
                case "front":
                    String item2 = queue.peek();
                    if(item2==null) {
                        sb.append(-1+"\n");
                        break;
                    }
//                    System.out.println(item2);
                    sb.append(item2+"\n");
                    break;
                case "back":
                    String item3 = queue.back();
                    if(item3==null) {
                        sb.append(-1+"\n");
                        break;
                    }
//                    System.out.println(item3);
                    sb.append(item3+"\n");
                    break;

            }
        }
        System.out.println(sb.toString());
    }
    /*
    큐 : 선입선출
    창구
     ㅁ   0번고객 - 1번고객 - 2번고객

     3번 고객 추가되면
     창구
     ㅁ   0번고객 - 1번고객 - 2번고객 - 3번 고객

     0번 고객을 꺼낸다.
     창구
     ㅁ   1번고객 - 2번고객 - 3번 고객

 */

// void enqueue(Item item) : 아이템 추가
// Item dequeue() : 아이템 꺼내기, 동시에 제거
// boolean isEmpty() : 큐가 비어있는지
// int size() : 큐에 있는 항목의 개수


    public static class Queue<Item> {

        private Node<Item> first; // 제일 처음 데이터
        private Node<Item> last; // 제일 마지막 데이터
        private int n;

        private static class Node<Item>{
            private Item item;
            private Node<Item> next;
        }
        public Queue(){
            first=null;
            last=null;
            n=0;
        }
        //비어있으면 true

        public boolean isEmpty(){
            return first==null;
        }
        public int size(){
            return n;
        }
        public void push(Item item){
            //마지막 item이었던 last를 새로 들어온 item으로 바꿔준다.

            //새 아이템이 들어오기 전 last를 저장
            Node<Item> oldLast = last;
            //들어온 새 아이템으로 새 last를 생성
            last =new Node<>();
            last.item=item;
            last.next=null;

            //새로 들어온 데이터가 첫 데이터인 경우
            //그 데이터는 last인 동시에 first가 된다.
            if(isEmpty()){
                first=last;
            }else {
                oldLast.next=last;
            }
            //데이터 추가 됐으니 n 증가
            n++;
        }
        //아이템 꺼내기
        public Item pop(){
            //Item을 꺼낼 때는 꺼낼 아이템이 있는지 먼저 확인
            if(isEmpty()){
                return null;
            }
            //반환할 item
            Item item = first.item;
            //이제 first 는 필요가 없다.
            //first의 다음 차례인 item을 first로 설정
            first=first.next;
            //아이템이 1개 사라졌으니
            n--;
            // 만약 first가 동시에 last였다면 == 데이터가 1개 뿐
            if(isEmpty()){
                last=null;
            }
            return item;
        }
        //peek() : 맨처음 아이템을 꺼내지만 삭제는 안함(복사해서 돌려줌)
        public Item peek(){
            if(isEmpty()){

                return null;
            }
            return first.item;
        }
        public Item back(){
            if(isEmpty()){
                return null;
            }
            return last.item;
        }
    }

}
