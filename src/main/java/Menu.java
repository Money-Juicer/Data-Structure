import List.Node;
import List.List;
import student.Sex;
import student.Student;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final List<Student> list;

    public Menu(List<Student> list) {
        scanner = new Scanner(System.in);
        this.list = list;
    }

    public void run() {
        while (true) {
            System.out.println("### MENU ###");
            System.out.println("1. Insert student.");
            System.out.println("2. Delete student.");
            System.out.println("3. Search student.");
            System.out.println("4. Print All.");
            System.out.println("5. Exit");
            System.out.print("> ");
            int input = scanner.nextInt();

            System.out.println();

            process(input);
        }
    }

    private void process(int input) {
        switch (input) {
            case 1:
                insert();
                break;
            case 2:
                delete();
                break;
            case 3:
                find();
                break;
            case 4:
                printAll();
                break;
            case 5:
                exit();
            default:
                System.out.println("Wrong Input. Try Again.\n");
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void printAll() {
        System.out.println("### Student Info ###");
        list.print();
        System.out.println();
    }

    private void find() {
        System.out.print("Student ID: ");
        Long id = scanner.nextLong();
        Student node = list.find(new Student(id));
        if (node == null) {
            System.out.println("No match...\n");
            return;
        }
        System.out.println(node);
        System.out.println();
    }

    private void delete() {
        System.out.println("1. Delete with index of the list.");
        System.out.println("2. Delete with student ID.");
        System.out.print("> ");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.print("Index: ");
                int index = scanner.nextInt();
                list.delete(index);
                break;
            case 2:
                System.out.print("Student ID: ");
                Long id = scanner.nextLong();
                list.delete(new Student(id));
                break;
            default:
                System.out.println("Wrong Input. Try Again.");
        }
        System.out.println();
    }

    private void insert() {
        Student student = makeStudent();

        System.out.println("1. Insert at the end of the list.");
        System.out.println("2. Insert at a specific index in the list.");
        System.out.print("> ");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                list.insert(student);
                break;
            case 2:
                System.out.print("Index: ");
                int index = scanner.nextInt();
                list.insert(index, student);
                break;
            default:
                System.out.println("Wrong Input. Try Again.");
        }
        System.out.println();
    }

    private Student makeStudent() {
        System.out.println("### Input Student Info ###");

        System.out.print("Student Name: ");
        String name = scanner.next();

        System.out.print("Student ID: ");
        long id = scanner.nextLong();

        System.out.print("Sex(1. Male, 2. Female): ");
        int x = scanner.nextInt();
        Sex sex = Sex.values()[x - 1];

        System.out.println();

        return new Student(name, id, sex);
    }
}
