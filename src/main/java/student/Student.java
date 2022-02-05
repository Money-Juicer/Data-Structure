package student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student {
    private String name;
    private Long id;
    private Sex sex;

    public Student(Long id) {
        this.id = id;
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
