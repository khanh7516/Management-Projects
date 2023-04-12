package entity;
public class Student {
    private static int autoId;
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.id = ++autoId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return '\n'+ "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                "}\n";
    }
}
