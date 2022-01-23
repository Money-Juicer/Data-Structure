package List;

public interface List<E> {

    void insert(Node<E> node);

    void insert(int index, Node<E> node);

    void delete(int index);

    void delete(Node<E> node);

    Node<E> find(E element);

    void print();
}
