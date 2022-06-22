import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main10828 {
    public static void main(String[] args) {
        Stack<String> stack =new Stack<>();
        StringBuilder sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            String cmd = sc.next();
            switch (cmd){
                case "push":
                    int a= sc.nextInt();
                    stack.push(String.valueOf(a));
                    break;
                case "pop":
                    String item = stack.pop();
                    if(item==null) {
                        sb.append(-1+"\n");
                        break;
                    }
                    sb.append(item+"\n");
//                    System.out.println(item);
                    break;
                case "size":
                    sb.append(stack.size()+"\n");
//                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1+"\n");
                    else
                        sb.append(0+"\n");
                    break;
                case "top":
                    String item2 = stack.peek();
                    if(item2==null) {
                        sb.append(-1+"\n");
                        break;
                    }
//                    System.out.println(item2);
                    sb.append(item2+"\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    /*
        스택 : 후입 선출
        제일 먼저 들어간 데이터가 제일 나중에 나온다.
     */
    public static class Stack<Item> {
        private Node<Item> first; // 스택의 맨 위에 있는 항목
        private int n;
        public Stack(){
            first = null;
            n=0;
        }
        //스택이 비어있는지 알려주는 메소드
        //스택이 비어있다 ->true
        public boolean isEmpty(){
            if(first==null) return true;
            else return false;
        }
        public int size(){
            return n;
        }

        public void push(Item item){
            //스택에 새 항목이 들어오면
            //first -> 스택 맨 위에 있는 항목
            //first를 새로 들어온 항목으로 바꿔주고
            //first.next를 원래 있는 first로 해준다.
            Node<Item> oldfirst=first;
            first=new Node<>();
            first.item=item;
            first.next=oldfirst;
            n++;
        }
        public Item pop(){
            //스택이 비어있으면 못 꺼내니까 먼저 검사
            if(isEmpty())
                return null;
            Item item = first.item;
            first=first.next;
            n--;
            return item;

        }
        public Item peek(){
            if(isEmpty())
                return null;
            return first.item;
        }


        //스택의 데이터를 나타낼 Node 클래스
        private static class Node<Item>{
            private Item item; //노드 안에 들어있는 data
            private Node<Item> next;// 다음 노드를 가르킴


        }
    }

}
