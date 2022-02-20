package List;

public interface List<E> {

    void insert(E element);

    void insert(int index, E element);

    void delete(int index);

    void delete(E element);

    E find(E element);

    void print();
}
