package List;

public class Node<E> {
    private E element;  //Data of the node
    private Node<E> next; //Reference to the next node
    private Node<E> prev; //Reference to the previous node

    //########################################################
    public E getElement()
    {
        return element;
    }
    public void setElement(E element)
    {
        this.element = element;
    }
    //########################################################
    public Node<E> getNext()
    {
        return next;
    }
    public void setNext(Node<E> next)
    {
        this.next = next;
    }
    //########################################################
    public Node<E> getPrev()
    {
        return prev;
    }
    public void setPrev(Node<E> prev)
    {
        this.prev = prev;
    }
    //########################################################

    public Node(E element)
    {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
