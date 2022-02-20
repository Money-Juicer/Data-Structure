package List;

import org.junit.jupiter.api.Test;
import student.Sex;
import student.Student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArrayListTest {
    ArrayList<Student> list;

    Student a = new Student("지훈", 19, Sex.MALE);
    Student b = new Student("용우", 20, Sex.MALE);
    Student c = new Student("영현", 21, Sex.MALE);
    Student d = new Student("성훈", 22, Sex.MALE);

    @Test
    void abcd를_삽입할_수_있다() {
        list = new ArrayList<Student>();
        String expected = "[19] 지훈(MALE)\n" +
                "[20] 용우(MALE)\n" +
                "[21] 영현(MALE)\n" +
                "[22] 성훈(MALE)\n";

        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.toString()).isEqualTo(expected);
    }

    @Test
    void 특정_인덱스에_노드를_삽입할_수_있다() {
        list = new ArrayList<Student>();
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
    void base_capacity를_초과하여_삽입할_수_있다() {
        list = new ArrayList<Student>(2);
        String expected = "[19] 지훈(MALE)\n" +
                "[20] 용우(MALE)\n" +
                "[21] 영현(MALE)\n" +
                "[22] 성훈(MALE)\n";

        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.toString()).isEqualTo(expected);
    }

    @Test
    void abcd_중에서_b를_찾을_수_있다() {
        list = new ArrayList<Student>();
        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);

        Student findOne = list.find(b);

        assertThat(findOne).isNotNull();
        assertThat(findOne).isEqualTo(b);
    }

    @Test
    void abc_중에서_d를_찾을_수_없다() {
        list = new ArrayList<Student>();
        list.insert(a);
        list.insert(b);
        list.insert(c);

        Student findOne = list.find(d);

        assertThat(findOne).isNull();
    }

    @Test
    void size가_1인_리스트의_element를_삭제할_수_있다() {
        list = new ArrayList<Student>();
        list.insert(a);
        list.delete(0);

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void 두_개의_노드_중에서_마지막_노드를_삭제할_수_있다() {
        list = new ArrayList<Student>();
        list.insert(a);
        list.insert(b);

        list.delete(1);

        assertThat(list.find(b)).isNull();
    }

    @Test
    void 특정_노드로_삭제할_수_있다() {
        list = new ArrayList<Student>();
        list.insert(a);
        list.insert(b);

        list.delete(a);

        assertThat(list.find(a)).isNull();
    }

    @Test
    void 인덱스_범위를_초과해서_삽입하면_예외가_던져진다() {
        list = new ArrayList<Student>();
        list.insert(a);
        assertThatThrownBy(() -> list.insert(5, b)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 인덱스_범위를_초과해서_삭제하면_예외가_던져진다() {
        list = new ArrayList<Student>();
        list.insert(a);
        assertThatThrownBy(() -> list.delete(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}