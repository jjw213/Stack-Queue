import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


    /*
        Bag<item>
        Bag() 가장 기본적인 콜렉션

        void add(Item item) => 항목추가
        boolean isEmpty() => 백이 비어있는지
        int size() => 백에 들어있는 항목의 개수

     */
    //여기 안에서 사용되는 타입은 모두 Item 타입으로 변경
    //순회 가능하도록 Iterable 인터페이스를 구현
    //Iterable를 구현하면 forEach 사용가능 (for(Item i:Bag)같은..)
    //LinkedList 가 어떻게 구현되는지 알기위해!!!
    public class Bag<Item> implements Iterable<Item>{
        public static void main(String[] args) {
            //String 타입 data를 담을 Bag 생성
            Bag<String> bag = new Bag<String>();
            Scanner sc = new Scanner(System.in);
            for(int i=0;i<5;i++){
                System.out.print("문자열 입력 : ");
                String input = sc.next();
                bag.add(input);

            }
            System.out.println("가방에 들어간 item 개수 : "+bag.size());
            for(String s:bag){
                System.out.println(s);
            }
        }
        private Node<Item> first;//가방(Bag)에 들어있는 Node item
        /*  first Node          Node               Node
            [data | link]====>[data | link]=====>[data~~~
         */
        private int n;//가방(Bag)에 들어있는 Node가 몇 개인지 알려주는 변수
        public Bag(){
            first=null;//처음 생성 시 들어있는 데이터는 없음
            n=0; // 데이터가 없으니까 들어있는 데이터의 수도 0개
        }
        //Bag이 비어있는지 (가지고 있는 노드가 있는지 없는지 true, false)
        public boolean isEmpty(){
            //first가 null이면 비어있다 -> true 반환
            return first == null;
        }
        //Bag에 Node가 몇개 포함되어 있는지
        public int size(){
            return n;
        }
        public void add(Item item){
            Node<Item> oldFirst =first;
            //입력받은 Item 으로 Node 객체 새로생성
            first=new Node<>();

            //first 노드의 data를 입력받은 item으로 설정
            first.setData(item);

            //first의 다음 노드를 원래 가지고 있던 예전 first(oldFirst)로 설정
            first.setLink(oldFirst);
            n++;
        }

        //forEach 사용 가능하게 만드는 메소드
        //이 메소드를 구현하면 for(Item i:Bag)
        @Override
        public Iterator<Item> iterator() {
            //first 노드부터 시작하는 순회자 반환
            return new LinkedIterator(first);
        }

        //반복자, 순회자 구현
        //Node라는 객체의 순서를 알려줘야 java가 순서를 알게되고
        //forEach를 쓸 수 있게됨.
        private class LinkedIterator implements Iterator<Item>{
            private Node<Item> current; // 현재 가리키는 노드
            public LinkedIterator(Node<Item> first){
                current=first;
            }
            //다음 노드가 존재하는지
            @Override
            public boolean hasNext() {
                return current!=null;
            }
            //다음 노드를 어떻게 구성할건지 알려줘야함.
            @Override
            public Item next() {
                if(current ==null) throw new NoSuchElementException();
                Item item =current.getData();
                //item을 전달했으니 current는 다음 Node로 바꿔주기
                current=current.getLink();
                return item;
            }
        }
    }
    //데이터를 뜻하는 Node클래스 -> Bag라는 자료구조를 구성하는 데이터
    class Node<Item>
    {
        public Item getData() {
            return data;
        }

        public void setData(Item data) {
            this.data = data;
        }

        public Node<Item> getLink() {
            return link;
        }

        public void setLink(Node<Item> link) {
            this.link = link;
        }

        private Item data; // 노드가 가지고 있는 정보(데이터)
        private Node<Item> link; //다음 노드를 가르키는 객체
    }
