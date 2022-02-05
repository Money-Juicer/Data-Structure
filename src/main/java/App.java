import List.List;
import List.LinkedList;
import student.Student;

public class App {
    public static void main(String[] args) {
        List<Student> list = new LinkedList<Student>();
        Menu menu = new Menu(list);
        menu.run();
    }
}
