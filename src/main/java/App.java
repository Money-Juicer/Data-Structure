import List.LinkedList;
import List.List;
import List.Node;
import student.Sex;
import student.Student;

public class App {
    public static void main(String[] args) {
        List<Student> list = new LinkedList<Student>();
        Menu menu = new Menu(list);
        menu.run();

        LinkedList<student.Student> nLL = new LinkedList();

        student.Student a = new Student("지훈", 19, Sex.MALE);
        student.Student b = new Student("용우", 19, Sex.MALE);
        student.Student c = new Student("영현", 19, Sex.MALE);
        student.Student d = new Student("성훈", 19, Sex.MALE);

        Node<student.Student> sunghoon = new Node(d); //성훈이 노드 생성
        nLL.insert(new Node(a));
        nLL.insert(new Node(b));
        nLL.insert(new Node(c));
        nLL.find(b).getElement().print(); //용우 노드의 위치 출력
        nLL.print(); //리스트에 있는 노드 갯수 출력
        nLL.insert(2, sunghoon); //성훈이 노드 2번 인덱스에 추가
        nLL.print(); //리스트에 있는 노드 갯수 출력
        for(int i = 0; i < nLL.size(); i++) //리스트에 있는 노드 전부 출력하기
        {
            nLL.getElement(i).print();
        }
        System.out.println("End of print");
        nLL.delete(sunghoon); //성훈이 노드 제거
        for(int i = 0; i < nLL.size(); i++) //리스트에 있는 노드 전부 출력하기
        {
            nLL.getElement(i).print();
        }
        System.out.println("End of print");
        nLL.print(); //리스트에 있는 노드 갯수 출력
    }
}
