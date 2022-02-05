package student;

public class Student {
    public Student(String name, long id, Sex sex){
        this.name = name;
        this.id = id;
        this.sex = sex;
    }
    public void print()
    {
        System.out.println("Name = "+name +", id = "+id+", Sex = "+sex);
    }
    private String name;
    private long id;
    private Sex sex;
}
