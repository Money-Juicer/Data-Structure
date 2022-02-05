package List;

public class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E element) {
        this.element = element;
    }
}
