package List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.Sex;
import student.Student;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    private LinkedList<Student> list;

    Student a = new Student("지훈", 19, Sex.MALE);
    Student b = new Student("용우", 19, Sex.MALE);
    Student c = new Student("영현", 19, Sex.MALE);
    Student d = new Student("성훈", 19, Sex.MALE);

    @BeforeEach
    void setUp() {
        list = new LinkedList<Student>();
    }

    @Test
    void 하나의_노드를_삭제할_수_있다() {
        list.insert(new Node(a));
        list.delete(0);

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void abcd_중에서_b를_반환할_수_있다() {
        list.insert(new Node(a));
        Node bNode = new Node(b);
        list.insert(bNode);
        list.insert(new Node(c));
        list.insert(new Node(d));

        Node<Student> findNode = list.find(b);
        assertThat(bNode).isEqualTo(findNode);
    }

    @Test
    void 두_개의_노드_중에서_마지막_노드를_삭제할_수_있다() {
        list.insert(new Node(a));
        list.insert(new Node(b));

        list.delete(1);

        assertThat(list.find(b)).isNull();
    }

    @Test
    void 특정_노드로_삭제할_수_있다() {
        Node aNode = new Node(a);
        list.insert(aNode);
        list.insert(new Node(b));

        list.delete(aNode);

        assertThat(list.find(a)).isNull();
    }

    @Test
    void 특정_인덱스에_노드를_삽입할_수_있다() {
        String expected = "[19] 용우(MALE)\n" +
                "[19] 성훈(MALE)\n" +
                "[19] 지훈(MALE)\n" +
                "[19] 영현(MALE)\n";

        list.insert(new Node(a));
        list.insert(0, new Node(b));
        list.insert(2, new Node(c));
        list.insert(1, new Node(d));

        assertThat(list.toString()).isEqualTo(expected);
    }

    @Test
    void 리스트를_출력할_수_있다() {
        String expected = "[19] 지훈(MALE)\n" +
                "[19] 용우(MALE)\n" +
                "[19] 영현(MALE)\n";

        list.insert(new Node(a));
        list.insert(new Node(b));
        list.insert(new Node(c));

        assertThat(list.toString()).isEqualTo(expected);
    }

}