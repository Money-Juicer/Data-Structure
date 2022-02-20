package List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.Sex;
import student.Student;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    private LinkedList<Student> list;

    Student a = new Student("지훈", 19, Sex.MALE);
    Student b = new Student("용우", 20, Sex.MALE);
    Student c = new Student("영현", 21, Sex.MALE);
    Student d = new Student("성훈", 22, Sex.MALE);

    @BeforeEach
    void setUp() {
        list = new LinkedList<Student>();
    }

    @Test
    void 하나의_노드를_삭제할_수_있다() {
        list.insert(a);
        list.delete(0);

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void abcd_중에서_b를_반환할_수_있다() {
        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);

        Student findNode = list.find(b);
        assertThat(b).isEqualTo(findNode);
    }

    @Test
    void 두_개의_노드_중에서_마지막_노드를_삭제할_수_있다() {
        list.insert(a);
        list.insert(b);

        list.delete(1);

        assertThat(list.find(b)).isNull();
    }

    @Test
    void 특정_노드로_삭제할_수_있다() {
        list.insert(a);
        list.insert(b);

        list.delete(a);

        assertThat(list.find(a)).isNull();
    }

    @Test
    void 특정_인덱스에_노드를_삽입할_수_있다() {
        String expected = "[20] 용우(MALE)\n" +
                "[22] 성훈(MALE)\n" +
                "[19] 지훈(MALE)\n" +
                "[21] 영현(MALE)\n";

        list.insert(a);
        list.insert(0, b);
        list.insert(2, c);
        list.insert(1, d);

        assertThat(list.toString()).isEqualTo(expected);
    }

    @Test
    void 리스트를_출력할_수_있다() {
        String expected = "[19] 지훈(MALE)\n" +
                "[20] 용우(MALE)\n" +
                "[21] 영현(MALE)\n";

        list.insert(a);
        list.insert(b);
        list.insert(c);

        assertThat(list.toString()).isEqualTo(expected);
    }

}