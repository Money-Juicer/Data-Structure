package List;

/**
 * Author: Yongwoo
 * @param <E> - the type of elements in this list
 */
public class ArrayList<E> implements List<E> {
    private int capacity;
    private int lastIndex;
    private E[] array;

    public ArrayList() {
        capacity = 10;
        array = (E[]) new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    @Override
    public void insert(E element) {
        if (isFull()) {
            makeLongerArray();
        }

        array[lastIndex++] = element;
    }

    @Override
    public void insert(int index, E element) {
        if (isOutOfBound(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (isFull()) {
            makeLongerArray();
        }

        for (int i = lastIndex; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        lastIndex++;
    }

    @Override
    public void delete(int index) {
        if (isOutOfBound(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (lastIndex == 0) {
            throw new IllegalStateException("Cannot delete when the size is 0");
        }

        for (int i = index; i < lastIndex; i++) {
            array[i] = array[i + 1];
        }
        lastIndex--;
    }

    @Override
    public void delete(E element) {
        if (lastIndex == 0) {
            throw new IllegalStateException("Cannot delete when the size is 0");
        }

        int index = findIndex(element);
        if (index == -1) {
            throw new IllegalArgumentException("Cannot find element");
        }

        for (int i = index; i < lastIndex; i++) {
            array[i] = array[i + 1];
        }
        lastIndex--;
    }

    @Override
    public E find(E element) {
        int index = findIndex(element);
        if (index == -1) {
            return null;
        }
        return array[index];
    }

    @Override
    public void print() {
        System.out.println("There are currently "+ lastIndex + " node(s).");
    }

    public int size() {
        return lastIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastIndex; i++) {
            sb.append(array[i].toString()).append('\n');
        }
        return sb.toString();
    }

    private int findIndex(E element) {
        for (int index = 0; index < lastIndex; index++) {
            if (element.equals(array[index])) {
                return index;
            }
        }
        return -1;
    }

    private void makeLongerArray() {
        int newCapacity = 2 * capacity;
        E[] newArray = (E[]) new Object[newCapacity];

        for (int i = 0; i < lastIndex; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    private boolean isOutOfBound(int index) {
        return index > lastIndex;
    }

    private boolean isFull() {
        return capacity <= lastIndex;
    }
}
