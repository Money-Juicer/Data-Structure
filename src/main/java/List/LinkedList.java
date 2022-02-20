package List;

/**
 * Jihoon
 * @param <E> element
 */
public class LinkedList<E> implements List<E> {
    Node<E> head;
    private int length = 0;

    public LinkedList() {this.head = null;} //Constructor for the list

    @Override //맨 끝에 노드 추가하기
    public void insert(E element) {
        Node<E> eNode = new Node<>(element);
        if(this.head == null) { //노드가 비어 있을 경우에 그냥 새로이 헤드로 지정한다
            head = eNode;
            System.out.println("Node added"); //최초 노드
        }
        else { //이미 노드가 존재할 경우
            Node<E> temp = head;
            while(temp.getNext() != null) { //마지막 노드에 당도할 때까지 반복문
                temp = temp.getNext();
            }
            temp.setNext(eNode); //마지막 노드의 다음으로(next) 새로운 노드 추가
            eNode.setPrev(temp); //새로운 노드의 이전으로(prev) 마지막 노드 추가
        }
        length++; //노드 길이가 연장 되었음을 기록
        System.out.println("Node added");
    }

    @Override //지정 인덱스 위치에 노드 추가하기
    public void insert(int index, E element) {
        Node<E> eNode = new Node<>(element);
        Node<E> temp = head;
        if(index > length) { //입력 된 위치가 존재하는 위치인지 확인하는 절차
            System.out.println("Invalid index! ");
            return;
        }
        if(index == 0 ) { //위치가 0일 경우
            head = eNode; //위치 0에 추가할 노드를 Head 로 지정
            head.setNext(temp); //헤드의 Next 에 기존 노드 연결
            temp.setPrev(head); //기존 노드의 Prev 에 새로운 노드 연결
            length++; //노드 길이가 연장 되었음을 기록
            return;
        }
        int count = 1;
        while(count < index) { //입력한 위치에 존재하는 노드로 이동하기 위한 반복문
            temp = temp.getNext();
            count++;
        }
        if(temp.getNext() != null){ //위치(인덱스)에 있는 노드가 마지막 노드가 아니라면
            eNode.setNext(temp.getNext());
            temp.getNext().setPrev(eNode);
        }
        //위치(인덱스)에 있는 노드가 마지막 노드일 경우 단독 실행
        eNode.setPrev(temp);
        temp.setNext(eNode);
        length++;
    }

    @Override //인덱스 위치에 있는 노드 삭제
    public void delete(int index) {
        if(index > length) {
            System.out.println("Invalid index! "+index);
            return;
        }
        if(index == 0) {
            if(head.getNext() != null){
                head = head.getNext();
            }
            else{
                head = null;
            }
            length--;
            return;
        }
        Node<E> temp = head;
        int count = 0;
        while(count < index) {
            temp = temp.getNext();
            count++;
        }
        if(temp.getNext() != null) {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
        }
        else if(temp.getNext() == null) {
            temp.getPrev().setNext(null);
        }
        length--;
    }

    @Override //내용물로 노드 인덱스 찾기
    public E find(E element) {
        int index = 0;
        Node<E> temp = head;

        if(temp.getElement().equals(element))
        {
            System.out.println("Node located at index "+index+".");
            return temp.getElement();
        }
        while(temp.getNext() != null)
        {
            index++;
            if(temp.getNext().getElement().equals(element))
            {
                System.out.println("Node located at index "+index+".");
                return temp.getNext().getElement();
            }
            temp = temp.getNext();
        }
        System.out.println("Unable to locate node.");
        return null;
    }

    @Override //내용물 갯수 출력하기
    public void print() {
        Node<E> temp = head;

        System.out.println("There are currently "+ length +" node(s).");
    }

    @Override //인덱스가 아닌 노드 지정 삭제
    public void delete(E element) {
        Node<E> eNode = new Node<>(element);
        Node<E> temp = head;
        if(temp.equals(eNode)) {
            if(head.getNext() != null){
                head = head.getNext();
            }
            else{
                head = null;
            }
            length--;
            return;
        }
        while(temp != null)
        {
            if(temp.equals(eNode)) {
                if(temp.getNext() != null) {
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                }
                else{
                    temp.getPrev().setNext(null);
                }
                length--;
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Unable to locate Node.");
    }

    public int size() //리스트 사이즈 반환
    {
        return length;
    }

    public E getElement(int index)
    {
        Node<E> temp = head;
        for(int i = 0; i < index; i++)
        {
            temp = temp.getNext();
        }
        return temp.getElement();
    }

    @Override
    public String toString() {
        String result = "";
        Node temp = head;

        while (temp != null) {
            result += temp.getElement().toString() + '\n';
            temp = temp.getNext();
        }

        return result;
    }
}
