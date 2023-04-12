package entity;

import java.util.ArrayList;

public class Classroom {
    private String subject;
    private ArrayList<Student> students;

    public Classroom(String subject, ArrayList<Student> students) {

        this.subject = subject;
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return
                "\n\tBộ môn: " + subject +
                "\n\tDanh sách học sinh: " + students;
    }
}
