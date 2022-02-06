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
    public void insert(Node<E> node) {
        if(this.head == null)
        {
            head = node;
            System.out.println("First node placed"); //최초 노드
        }
        else
        {
            Node<E> temp = head;
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(node); //마지막 노드의 다음으로(next) 새로운 노드 추가
            node.setPrev(temp); //새로운 노드의 이전으로(prev) 마지막 노드 추가
            System.out.println("추가 노드"); //기존 리스트에 추가 노드
        }
        length++;

        System.out.println("Successfully placed additional node");
    }

    @Override //지정 인덱스 위치에 노드 추가하기
    public void insert(int index, Node<E> node) {
        if(index > length - 1)
        {
            System.out.println("Invalid index! "+index);
            return;
        }
        if(index == 0 )
        {
            Node<E> temp = head;
            head = node;
            head.setNext(temp);
            temp.setPrev(head);
            length++;
            return;
        }
        Node<E> temp = head;
        int count = 1;
        while(count < index)
        {
            temp = temp.getNext();
            count++;
        }
        if(temp.getNext() != null){
            node.setNext(temp.getNext());
            temp.getNext().setPrev(node);
        }
        node.setPrev(temp);
        temp.setNext(node);
        length++;
    }

    @Override //인덱스 위치에 있는 노드 삭제
    public void delete(int index) {
        if(index > length - 1)
        {
            System.out.println("Invalid index! "+index);
            return;
        }
        if(index == 0)
        {
            head = head.getNext();
        }
        Node<E> temp = head;
        int count = 0;
        while(count < index)
        {
            temp = temp.getNext();
            count++;
        }
        if(temp.getNext() != null)
        {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
        }
        else if(temp.getNext() == null)
        {
            temp.getPrev().setNext(null);
        }
        length--;
    }

    @Override //내용물로 노드 인덱스 찾기
    public Node<E> find(E element) {
        int index = 0;
        Node<E> temp = head;

        if(temp.getElement().equals(element))
        {
            System.out.println("Node located at index "+index+".");
            return temp;
        }
        while(temp.getNext() != null)
        {
            index++;
            if(temp.getNext().getElement().equals(element))
            {
                System.out.println("Node located at index "+index+".");
                return temp.getNext();
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
    public void delete(Node<E> node) {
        Node<E> temp = head;
        if(temp.equals(node))
        {
            head = temp.getNext();
            // TODO: pointer 정리
            length--;
            return;
        }
        while(temp != null)
        {
            if(temp.equals(node))
            {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                length--;
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Unable to locate node.");
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
