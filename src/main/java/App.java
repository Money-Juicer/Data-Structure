import List.LinkedList;
import List.List;
import student.Student;

public class App {
    public static void main(String[] args) {
        List<Student> list = new LinkedList<Student>();
        Menu menu = new Menu(list);
        menu.run();
    }
}
