package student;

public class Student {
    private String name;
    private Long id;
    private Sex sex;

    public Student(String name, long id, Sex sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    public Student(Long id) {
        this.id = id;
    }

    public void print() {
        System.out.println("Name = "+name +", id = "+id+", Sex = "+sex);
    }

    @Override
    public String toString() {
        return "[" + id + "]" + " " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        return id.equals(((Student) obj).id);
    }
}
